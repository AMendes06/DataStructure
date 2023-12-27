/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Menu;

import Player.Player;
import Enum.EnumTeam;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Import.ImportJsonFile;
import Local.Connector;
import Local.Coordinates;
import Local.Local;
import Local.ManagementLocal;
import Local.Ownership;
import Local.Portal;
import Player.Actions;
import Player.ManagementPlayer;
import Route.CalculateDistance;
import Route.ManagementRoute;
import Route.Route;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import linkedqueue.LinkedQueue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Console {

    private final static String START = "\nPretende iniciar um novo jogo\n"
            + "1.Inciar Jogo \n"
            + "0.Sair \n";

    //Print MENU
    private final static String MENU = "\nMenu Principal:\n"
            + "1.Jogar \n"
            + "2.Player \n"
            + "3.Locais \n"
            + "4.Rotas \n"
            + "5.Importar ficheiro JSON \n"
            + "6.Configuracoes do jogo\n"
            + "0.Sair";

    //Print SELLERSMENU
    private final static String PLAYERMENU = "\n Player:\n"
            + "1.Gestao Player \n"
            + "2.Listar Players \n"
            + "3.Listar Players por equipa\n"
            + "4.Listar Players por nivel\n"
            + "5.Exportar Ficheiro JSON Players\n"
            + "0.Voltar para o Menu";

    //PRINT SELLERSMANAGEMENTMENU
    private final static String PLAYERMANAGEMENTMENU = "\nGestao Player \n"
            + "1.Adicionar Player \n"
            + "2.Remover Player \n"
            + "3.Editar Player \n"
            + "4.Mudar Player de equipa\n"
            + "0.Voltar";

    //PRINT LOCALSMENU
    private final static String LOCALSMENU = "\nLocais \n"
            + "1.Portais \n"
            + "2.Conetores \n"
            + "3.Exportar Locals\n"
            + "0.Voltar";

    //PRINT MARKETSMANAGEMENTMENU
    private final static String PORTALMANAGEMENTMENU = "\nGestao Portal \n"
            + "1.Criar Portal  \n"
            + "2.Remover Portal  \n"
            + "3.Editar Portal \n"
            + "4.Listar Portal \n"
            + "5.Listar Portal por Energia \n"
            + "6.Exportar Ficheiro JSON Portais\n"
            + "0.Voltar";

    //PRINT WAREHOUSEMANAGEMENTMENU 
    private final static String CONNETORMANAGEMENTMENU = "\nGestao Conetores \n"
            + "1.Criar Conetores \n"
            + "2.Remover Conetores \n"
            + "3.Editar Conetores \n"
            + "4.Listar Conectores \n"
            + "5.Listar conectores por energia\n"
            + "6.Exportar Ficheiro JSON Conectores \n"
            + "0.Voltar";

    private final static String ROTASMANAGEMENTMENU = "\nGestao Rotas \n"
            + "1.Criar Rotas \n"
            + "2.Remover rotas \n"
            + "3.Listar rotas \n"
            + "4.Exportar Ficheiro JSON rotas \n"
            + "0.Voltar";

    //PRINT PARA O JOGO
    private final static String JOGAR = "\n Inicio de jogo:\n"
            + "1.Conquistar Portal\n"
            + "2.Carregar Portal\n"
            + "3.Recarregar Energia\n"
            + "0.Voltar";

    //PRINT PARA O configurações
    private final static String CONFIGURACOES = "\n Configuracoes de jogo:\n"
            + "1.Calcular distancia entre Locais\n"
            + "2.Configurações do jogo\n"
            + "3.Exportar configurações do jogo\n"
            + "0.Voltar";

    //print para Menu da equipa
    private final static String EQUIPAMENU = "\nEscolher Equipa:\n"
            + "1.Giants\n"
            + "2.Sparks\n"
            + "3.Neutral\n";

    //Variables
    private Scanner scanner;
    private ManagementLocal managementLocal;
    private ManagementRoute managementRoute;
    private ManagementPlayer managementPlayer;
    private final LinkedQueue listPlayers = new LinkedQueue();
    private Player CircularPlayer = new Player();

    public Console() {
        this.scanner = new Scanner(System.in);
        this.managementLocal = new ManagementLocal();
        this.managementRoute = new ManagementRoute();
        this.managementPlayer = new ManagementPlayer();
    }

    /**
     * Start Menu
     */
    public void Start() throws EmptyCollectionException, ParseException, ElementNotFoundException {
        boolean exit = false;
        while (!exit) {
            System.out.println(START);
            switch (scanner.nextLine()) {
                case "1": {
                    System.out.println("");
                    exit = true;
                    menu();
                    break;
                }
                case "0": {
                    exit = true;
                    break;
                }

            }

        }
    }

    public void menu() throws EmptyCollectionException, ParseException, ElementNotFoundException {
        boolean exit = false;
        while (!exit) {
            System.out.println(MENU);
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1: {
                    jogar();
                    break;
                }
                case 2: {
                    players();
                    break;
                }
                case 3: {
                    locals();
                    break;
                }
                case 4: {
                    rotas();
                    break;
                }
                case 5: {
                    System.out.println(importJson());
                    break;
                }
                case 6: {
                    configuracoes();
                    break;
                }

                case 0: {
                    exit = true;
                }
            }
        }
    }

    public void configuracoes() {
        boolean exit = false;
        while (!exit) {
            System.out.println(CONFIGURACOES);
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1: {
                    calcularDistanciaEntreLocals();
                    break;
                }
                case 2: {
                    System.out.println(shortPathBetweenTwoLocals());
                    break;
                }
                case 3: {
                    //exportConfiguracoesJogo();
                    break;
                }
                case 4: {
                    //ConfiguracoesJogo();
                    break;
                }

                case 0: {
                    exit = true;
                }
            }
        }

    }
    
    public String shortPathBetweenTwoLocals(){
        int idLocal1;
        int idLocal2;
        
        
        System.out.println("ID do Local:");
        idLocal1 = Integer.parseInt(scanner.nextLine());

        System.out.println("ID do local:");
        idLocal2 = Integer.parseInt(scanner.nextLine());;
        
        Local local1 = managementLocal.findLocalNetwork(idLocal1);
        Local local2= managementLocal.findLocalNetwork(idLocal2);
        
         
        System.out.println(managementRoute.ShortestPath(local1, local2));
        
        return "Foi calculado o caminho mais curto entre esses Locais!";
    }

    public void calcularDistanciaEntreLocals() {
        int idLocal1;
        int idLocal2;
        System.out.println("Calculo Distancia entre dois locais: \n");

        System.out.println("ID do Local:");
        idLocal1 = Integer.parseInt(scanner.nextLine());

        System.out.println("ID do local:");
        idLocal2 = Integer.parseInt(scanner.nextLine());;

        Local local1 = managementLocal.findLocalNetwork(idLocal1);
        Local local2 = managementLocal.findLocalNetwork(idLocal2);
        double latitude1 = (double) local1.getCoordinates().getLatitude();
        double longitude1 = (double) local1.getCoordinates().getLongitude();

        double latitude2 = (double) local2.getCoordinates().getLatitude();
        double longitude2 = (double) local2.getCoordinates().getLongitude();

        CalculateDistance.calculateDistanceWithTwoPoints(longitude1, latitude1, longitude2, latitude2);

    }

    public void rotas() throws ElementNotFoundException {
        boolean exit = false;
        while (!exit) {
            System.out.println(ROTASMANAGEMENTMENU);
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1: {
                    System.out.println(addRotas());
                    break;
                }
                case 2: {
                    System.out.println(removerRotas());
                    break;
                }
                case 3: {
                    managementRoute.listRoutes();
                    break;
                }
                case 4: {
                    managementRoute.exportRouteToJson();
                    break;
                }
                case 5: {

                    break;
                }
                case 0: {
                    exit = true;
                }
            }
        }
    }

    public String addRotas() {
        int id1;
        int id2;

        System.out.println("ID do primeiro Local:");
        id1 = Integer.parseInt(scanner.nextLine());

        System.out.println("ID do Segundo local:");
        id2 = Integer.parseInt(scanner.next());

        Local local1 = managementLocal.findLocalNetwork(id1);
        Local local2 = managementLocal.findLocalNetwork(id2);

        try {
            managementRoute.addRoute(local1, local2);
        } catch (NoSuchElementException ex) {
            return "Não foi possivel adicionar a rota!";

        }
        return "Rota adicionada com sucesso!";

    }

    public String removerRotas() {
        int id1;
        int id2;

        System.out.println("ID do Local:");
        id1 = Integer.parseInt(scanner.nextLine());

        System.out.println("ID do local:");
        id2 = Integer.parseInt(scanner.next());

        Local local1 = managementLocal.findLocalNetwork(1);
        Local local2 = managementLocal.findLocalNetwork(id2);

        try {
            managementRoute.removeRoute(local1, local2);
        } catch (NoSuchElementException ex) {
            return "Não foi possivel remover a rota!";

        }
        return "Rota removida com sucesso!";

    }

    public void jogar() throws EmptyCollectionException {
        boolean exit = false;
        while (!exit) {
            System.out.println(JOGAR);
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1: {
                    System.out.println(conquistarPortal());
                    break;
                }
                case 2: {
                    System.out.println(carregarPortal());
                    break;
                }
                case 3: {
                    System.out.println(recarregarEnergiaPlayer());
                    break;
                }
                case 0: {
                    exit = true;
                }

            }

        }
    }

    public String recarregarEnergiaPlayer() throws EmptyCollectionException {
        String playerName;
        int connectorName;

        Actions actions = new Actions();

        System.out.println("Nome do Player:");
        playerName = scanner.nextLine();

        System.out.println("ID do Connector:");
        connectorName = Integer.parseInt(scanner.next());

        Player player = managementPlayer.findPlayer(playerName);
        Connector connector1 = (Connector) managementLocal.findConnectorNetwork(connectorName);

        try {
            actions.rechargeEnergyPlayer(player, connector1);
        } catch (EmptyCollectionException ex) {
            turnNextPlayer();
            return "Não foi possivel carregador energia do jogador!\n";

        }
        turnNextPlayer();
        return "Energia do jogador carregada com sucesso!\n";

    }

    public String carregarPortal() throws EmptyCollectionException {
        String playerName;
        int id;
        int energia;

        Actions actions = new Actions();

        System.out.println("Nome do Player:");
        playerName = scanner.nextLine();

        System.out.println("Nome do Portal:");
        id = Integer.parseInt(scanner.nextLine());

        System.out.println("Quantidade de Energia");
        energia = Integer.parseInt(scanner.nextLine());

        Player player = managementPlayer.findPlayer(playerName);
        Portal portal = (Portal) managementLocal.findPortalNetwork(id);

        try {
            actions.rechargePortal(player, portal, energia);
        } catch (NoSuchElementException ex) {
            turnNextPlayer();
            return "\nNão foi possivel carregador portal!";

        }
        turnNextPlayer();
        return "\nPortal carregador com sucesso!";

    }

    public String conquistarPortal() throws EmptyCollectionException {
        String playerName;
        int id;
        Actions actions = new Actions();

        System.out.println("Nome do jogador: ");
        playerName = scanner.nextLine();

        System.out.println("Nome do Portal: ");
        id = Integer.parseInt(scanner.next());

        Player player = managementPlayer.findPlayer(playerName);
        Portal portal = (Portal) managementLocal.findPortalNetwork(id);

        try {
            actions.conquerPortal(player, portal);

        } catch (NoSuchElementException ex) {
            turnNextPlayer();
            return "\nPortal não foi conquistado !";

        }
        turnNextPlayer();
        return "\nPortal conquistado com sucesso !";

    }

    public void players() throws EmptyCollectionException {
        boolean exit = false;
        while (!exit) {
            System.out.println(PLAYERMENU);
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1: {
                    gestaoPlayer();
                    break;
                }
                case 2: {
                    managementPlayer.printPlayers();
                    break;
                }
                case 3: {
                    listPlayersByTeam();
                    break;
                }
                case 4: {
                    managementPlayer.listPlayerPerlevel();
                    break;
                }
                case 5: {
                    managementPlayer.exportPlayersToJson();
                    break;
                }
                case 0: {
                    exit = true;
                }

            }
        }

    }

    public void gestaoPlayer() throws EmptyCollectionException {
        boolean exit = false;
        while (!exit) {
            System.out.println(PLAYERMANAGEMENTMENU);
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1: {
                    System.out.println(adicionarPlayer());
                    break;
                }
                case 2: {
                    System.out.println(removePlayer());
                    break;
                }
                case 3: {
                    System.out.println(editarPlayer());
                    break;
                }
                case 4: {
                    System.out.println(changeTeamPlayer());
                    break;
                }
                case 0: {
                    exit = true;
                }

            }
        }
    }

    public String changeTeamPlayer() {

        String name;
        String team;

        System.out.println("Nome:");
        name = scanner.nextLine();

        team = escolherEquipa();
        EnumTeam team1 = EnumTeam.valueOf(team);

        Player player1 = managementPlayer.findPlayer(name);

        try {
            managementPlayer.changePlayerTeam(player1, team1);

        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel mudar o jogador de equipa";

        }
        return "\nO jogador mudou de equipa com sucesso!";

    }

    public String editarPlayer() {
        String name;
        String team;

        System.out.println("Nome:");
        name = scanner.nextLine();

        team = escolherEquipa();
        EnumTeam team1 = EnumTeam.valueOf(team);

        Player player = new Player(name, team1);
        try {
            managementPlayer.updatePlayer(player, name, team1);

        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel editar o jogador";

        }
        return "\nO jogador editado com sucesso!";

    }

    public String removePlayer() throws EmptyCollectionException {

        String name;

        System.out.println("Nome:");
        name = scanner.nextLine();

        try {
            managementPlayer.removePlayer(name);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel remover jogador";

        }
        return "\nO jogador removido com sucesso!";

    }

    public String adicionarPlayer() {
        String name;
        String team;

        System.out.println("Nome:");
        name = scanner.nextLine();

        team = escolherEquipa();
        EnumTeam team1 = EnumTeam.valueOf(team);

        Player player = new Player(name, team1);

        try {

            managementPlayer.addPlayer(player);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel adicionar o jogador";

        }
        return "\nO jogador adicionado com sucesso!";

    }

    private String escolherEquipa() {
        boolean exit = false;
        while (!exit) {
            System.out.println(EQUIPAMENU);
            switch (scanner.nextLine()) {
                case "1": {
                    return "SPARKS";
                }
                case "2": {
                    return "GIANTS";
                }
                case "3": {
                    return "NEUTRAL";
                }

            }
        }
        return null;
    }

    public void locals() throws EmptyCollectionException {
        boolean exit = false;
        while (!exit) {
            System.out.println(LOCALSMENU);
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1: {
                    portal();
                    break;
                }
                case 2: {
                    connector();
                    break;
                }
                case 3: {
                    managementLocal.exportConnectorsToJson();
                    managementLocal.exportPortalsToJson();
                    break;
                }
                case 0: {
                    exit = true;
                }

            }

        }
    }

    public void connector() throws EmptyCollectionException {
        boolean exit = false;
        while (!exit) {
            System.out.println(CONNETORMANAGEMENTMENU);
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1: {
                    System.out.println(criarConnector());
                    break;
                }
                case 2: {
                    System.out.println(removerConnector());
                    break;
                }
                case 3: {
                    System.out.println(editarConnector());
                    break;
                }
                case 4: {
                    managementLocal.getConnectors();
                    break;
                }
                case 5: {
                    managementLocal.exportConnectorsToJson();
                    break;
                }
                case 0: {
                    exit = true;
                }

            }

        }

    }

    public String editarConnector() {

        int id;
        int energy;
        int cooldown;
        int latitude;
        int longitude;

        System.out.println("id: ");
        id = Integer.parseInt(scanner.nextLine());

        System.out.println("Energy: ");
        energy = Integer.parseInt(scanner.nextLine());

        System.out.println("Cooldown: ");
        cooldown = Integer.parseInt(scanner.nextLine());

        System.out.println("Coordenadas, Latitude: ");
        latitude = Integer.parseInt(scanner.nextLine());

        System.out.println("Coordenadas, Longitude: ");
        longitude = Integer.parseInt(scanner.nextLine());

        Coordinates coord = new Coordinates(latitude, longitude);
        Local connector = managementLocal.findConnectorNetwork(id);
        try {
            managementLocal.editConnector((Connector) connector, id, cooldown, latitude, longitude);
        } catch (NoSuchElementException ex) {
            return "\nO Connector que pretende editar não existe!";

        }
        return "\nO connector foi editado com sucesso!";

    }

    public String removerConnector() throws EmptyCollectionException {
        int id;

        System.out.println("id: ");
        id = Integer.parseInt(scanner.nextLine());

        Connector connector = (Connector) managementLocal.findConnectorNetwork(id);

        try {
            managementLocal.removerConnector(connector);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel remover o connector!";

        }
        return "\nO connector foi removido com sucesso!";

    }

    public String criarConnector() {
        int id;
        int Cooldown;
        int energy;
        int latitude;
        int longitude;

        System.out.println("id: ");
        id = Integer.parseInt(scanner.nextLine());

        System.out.println("Cooldown: ");
        Cooldown = Integer.parseInt(scanner.nextLine());

        System.out.println("Energy: ");
        energy = Integer.parseInt(scanner.nextLine());

        System.out.println("Coordenadas, Latitude: ");
        latitude = Integer.parseInt(scanner.nextLine());

        System.out.println("Coordenadas, Longitude: ");
        longitude = Integer.parseInt(scanner.nextLine());

        Coordinates coord = new Coordinates(latitude, longitude);
        Connector connector = new Connector(energy, Cooldown, id, coord);
        try {
            managementLocal.addConnector(connector);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel criar o connector!";

        }
        return "\nO connector foi criado com sucesso!";
    }

    public void portal() throws EmptyCollectionException {
        boolean exit = false;
        while (!exit) {
            System.out.println(PORTALMANAGEMENTMENU);
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1: {
                    System.out.println(criarPortal());
                    break;
                }
                case 2: {
                    System.out.println(removerPortal());
                    break;
                }
                case 3: {
                    System.out.println(editarPortal());
                    break;
                }
                case 4: {
                    managementLocal.getPortals();
                    break;
                }
                case 5: {
                    managementLocal.exportPortalsToJson();
                }
                case 0: {
                    exit = true;
                }

            }

        }

    }

    public String editarPortal() {
        String name;
        int id;
        int energy;
        int maxEnergy;
        int latitude;
        int longitude;

        System.out.println("id do portal que pretende editar: ");
        id = Integer.parseInt(scanner.nextLine());

        System.out.println("Nome: ");
        name = scanner.nextLine();

        System.out.println("Energy: ");
        energy = Integer.parseInt(scanner.nextLine());

        System.out.println("Energia Maxima:: ");
        maxEnergy = Integer.parseInt(scanner.nextLine());

        System.out.println("Coordenadas, Latitude: ");
        latitude = Integer.parseInt(scanner.nextLine());

        System.out.println("Coordenadas, Longitude: ");
        longitude = Integer.parseInt(scanner.nextLine());

        Portal portal = (Portal) managementLocal.findLocalNetwork(id);

        try {
            managementLocal.editPortal(portal, name, maxEnergy, energy, latitude, longitude);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel editar o Portal!";

        }
        return "\nO portal foi editado com sucesso!";
    }

    public String removerPortal() throws EmptyCollectionException {
        int id;

        System.out.println("id: ");
        id = Integer.parseInt(scanner.nextLine());

        Portal portal = (Portal) managementLocal.findPortalNetwork(id);

        try {
            managementLocal.removePortal(portal);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel remover o Portal!";

        }
        return "\nO portal foi removido com sucesso!";

    }

    public String criarPortal() {
        String name;
        int id;
        int energy;
        int latitude;
        int longitude;

        System.out.println("id: ");
        id = Integer.parseInt(scanner.nextLine());

        System.out.println("Nome: ");
        name = scanner.nextLine();

        System.out.println("Energy: ");
        energy = Integer.parseInt(scanner.nextLine());

        System.out.println("Coordenadas, Latitude: ");
        latitude = Integer.parseInt(scanner.nextLine());

        System.out.println("Coordenadas, Longitude: ");
        longitude = Integer.parseInt(scanner.nextLine());

        Coordinates coord = new Coordinates(latitude, longitude);
        Portal portal = new Portal(energy, name, energy, id, coord);
        try {
            managementLocal.addPortal(portal);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel criar o Portal!";

        }
        return "\nO portal foi criado com sucesso!";
    }

    public String importJson() throws ParseException {
        ImportJsonFile importJson = new ImportJsonFile();
        try {
            importJson.importLocals(managementLocal, managementPlayer);
            importJson.importRoute(managementLocal, managementRoute);
            importJson.importPlayers(managementPlayer);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel importar dados!";

        }
        return ("\nDados importados com sucesso!");

    }

    private void listPlayersByTeam() {

        String team;

        team = escolherEquipa();
        EnumTeam team1 = EnumTeam.valueOf(team);

        managementPlayer.listPlayersByTeam(team1);

    }

    public void copyPlayers() {
        Iterator<Player> iter = (Iterator<Player>) managementPlayer.getPlayer();
        while (iter.hasNext()) {
            listPlayers.enqueue(iter.next());
        }
    }

    private void turnNextPlayer() throws EmptyCollectionException {
        CircularPlayer = (Player) listPlayers.dequeue();
        listPlayers.enqueue(CircularPlayer);

    }
}
