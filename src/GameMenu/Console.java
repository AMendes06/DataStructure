package GameMenu;

import GamePlayer.Player;
import Enums.EnumTeam;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import GameImport.ImportJsonFile;
import GameLocal.Connector;
import GameLocal.Coordinates;
import GameLocal.Local;
import GameLocal.Portal;
import GameMapa.Mapa;
import GamePlayer.Actions;
import GamePlayer.ManagementPlayer;
import GamePlayer.PlayerCooldown;
import GameDistance.CalculateDistance;
import GameLocal.Route;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import EstruturasLinkedQueue.LinkedQueue;
import GameLocal.Interaction;
import java.time.LocalDate;
import java.time.LocalTime;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Console {

    private final static String START = "\nPretende iniciar um novo jogo\n"
            + "1.Inciar Jogo \n"
            + "2.Importar dados \n"
            + "0.Sair \n";

    //Print MENU
    private final static String MENU = "\nMenu Principal:\n"
            + "1.Jogar \n"
            + "2.Player \n"
            + "3.Locais \n"
            + "4.Rotas \n"
            + "5.Configuracoes do jogo \n"
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
            + "4.Mover jogador\n"
            + "0.Voltar";

    //PRINT PARA O configurações
    private final static String CONFIGURACOES = "\n Configuracoes de jogo:\n"
            + "1.Calcular distancia entre Locais\n"
            + "2.Calcular o caminho mais curto entre dois locais\n"
            + "3.Calcular o caminho mais curto entre dois locais com obrigatoriedade\n"
            + "4.Verificar Interacoes com Connectores!\n"
            + "0.Voltar";

    //print para Menu da equipa
    private final static String EQUIPAMENU = "\nEscolher Equipa:\n"
            + "1.Giants\n"
            + "2.Sparks\n"
            + "3.Neutral\n";

    //Variables
    /**
     * The Console class is responsible for managing the game's console
     * interface and interacting with the user. It uses a scanner to read user
     * input and communicates with the game's Mapa and ManagementPlayer classes
     * to execute game actions.
     */
    private Scanner scanner;
    private Mapa mapa;
    private ManagementPlayer managementPlayer;
    private final LinkedQueue listPlayers = new LinkedQueue();
    private Player CircularPlayer = new Player();
    private Player currentPlayer;

    /**
     * Constructs a new Console object, initializing its scanner, mapa,
     * managementPlayer, and currentPlayer fields.
     */
    public Console() {
        this.scanner = new Scanner(System.in);
        this.mapa = new Mapa();
        this.managementPlayer = new ManagementPlayer();
        this.currentPlayer = new Player();
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
                case "2": {
                    importJson();
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
                    copyPlayers();
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
                    System.out.println(ViewInteration());
                    break;
                }
                case 0: {
                    exit = true;
                }
            }
        }

    }

    /**
     *
     * Displays the interactions of all connectors in the map.
     *
     * @return A String representation of the interactions of all connectors in
     * the map.
     */
    public String ViewInteration() {

        System.out.println("Aqui tem as iterações de todos os Connecters:\n ");
        for (Connector connector : mapa.getConnectors()) {
            connector.getInteractions();
            System.out.println(connector.getInteractions() + "\n");
        }
        return ViewInteration();

    }

    /**
     *
     * Calculates the shortest path between two locals in the map and prints the
     * list of locals that need to be crossed. It prompts the user for the IDs
     * of the two locals and retrieves them from the map. Then, it calculates
     * the shortest path between them using the Dijkstra's algorithm and prints
     * the IDs of the locals that need to be crossed to go from the first local
     * to the second one.
     *
     * @return A string indicating that the shortest path has been calculated.
     */
    public String shortPathBetweenTwoLocals() {
        int idLocal1;
        int idLocal2;

        System.out.println("ID do Local:");
        idLocal1 = Integer.parseInt(scanner.nextLine());

        System.out.println("ID do local:");
        idLocal2 = Integer.parseInt(scanner.nextLine());;

        Local local1 = mapa.findLocalNetwork(idLocal1);
        Local local2 = mapa.findLocalNetwork(idLocal2);

        System.out.println("Locais a passar: ");
        Iterator<Local> shortPath = mapa.ShortestPath(local1, local2);
        while (shortPath.hasNext()) {
            Local tempLocal = (Local) shortPath.next();
            System.out.println(tempLocal.getId());

        }

        return "Foi calculado o caminho mais curto entre esses Locais!";
    }

    /**
     *
     * Calculates the distance between two locals based on their latitude and
     * longitude coordinates. Asks for user input of the IDs of the two locals
     * and uses the {@link Mapa} instance to find them. Uses the
     * {@link CalculateDistance} class to calculate the distance.
     *
     * @return A String indicating if the calculation was successful or not.
     */
    public String calcularDistanciaEntreLocals() {
        int idLocal1;
        int idLocal2;
        System.out.println("Calculo Distancia entre dois locais: \n");

        System.out.println("ID do Local:");
        idLocal1 = Integer.parseInt(scanner.nextLine());

        System.out.println("ID do local:");
        idLocal2 = Integer.parseInt(scanner.nextLine());;

        Local local1 = mapa.findLocalNetwork(idLocal1);
        Local local2 = mapa.findLocalNetwork(idLocal2);
        double latitude1 = (double) local1.getCoordinates().getLatitude();
        double longitude1 = (double) local1.getCoordinates().getLongitude();

        double latitude2 = (double) local2.getCoordinates().getLatitude();
        double longitude2 = (double) local2.getCoordinates().getLongitude();

        try {
            CalculateDistance.calculateDistanceWithTwoPoints(longitude1, latitude1, longitude2, latitude2);
        } catch (NoSuchElementException ex) {
            return "Não foi possivel fazer o calculo";

        }
        return "Calculo realizado com sucesso!";

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
                    mapa.listRoutes();
                    break;
                }
                case 4: {
                    mapa.exportRouteToJson();
                    break;
                }

                case 0: {
                    exit = true;
                }
            }
        }
    }

    /**
     *
     * Adds a route between two Locals and assigns it to a team.
     *
     * @return a message indicating whether the route was added successfully or
     * not
     */
    public String addRotas() {
        int id1;
        int id2;
        String team;

        System.out.println("ID do primeiro Local:");
        id1 = Integer.parseInt(scanner.nextLine());

        System.out.println("ID do Segundo local:");
        id2 = Integer.parseInt(scanner.nextLine());

        team = escolherEquipa();
        EnumTeam team1 = EnumTeam.valueOf(team);

        Local local1 = mapa.findLocalNetwork(id1);
        Local local2 = mapa.findLocalNetwork(id2);
        Route rota = new Route(local1, local2);
        try {
            if (team1.equals(EnumTeam.GIANTS)) {

                mapa.getRoutesGiants().addToRear(rota);
            } else if (team1.equals(EnumTeam.SPARKS)) {
                mapa.getRoutesSparks().addToRear(rota);
            }

            mapa.addRoute(local1, local2);
        } catch (NoSuchElementException ex) {
            return "Não foi possivel adicionar a rota!";

        }
        return "Rota adicionada com sucesso!";

    }

    /**
     *
     * Removes a route between two locals specified by their IDs.
     *
     * @return a String indicating the success or failure of the operation.
     */
    public String removerRotas() {
        int id1;
        int id2;

        System.out.println("ID do Local:");
        id1 = Integer.parseInt(scanner.nextLine());

        System.out.println("ID do local:");
        id2 = Integer.parseInt(scanner.nextLine());

        Local local1 = mapa.findLocalNetwork(1);
        Local local2 = mapa.findLocalNetwork(id2);

        try {
            mapa.removeRoute(local1, local2);
        } catch (NoSuchElementException ex) {
            return "Não foi possivel remover a rota!";

        }
        return "Rota removida com sucesso!";

    }

    public void jogar() throws EmptyCollectionException {
        boolean exit = false;
        while (!exit) {
            mapa.atribuirMinas();
            turnNextPlayer();
            System.out.println("Jogador a jogar: " + currentPlayer.getName());
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
                case 4: {
                    moverJogador();
                    break;
                }
                case 0: {
                    exit = true;
                }

            }

        }
    }

    /**
     *
     * Recharge the energy of the current player by connecting to a given
     * connector.
     *
     * @return a message indicating the success or failure of the action
     *
     * @throws EmptyCollectionException if the collection is empty
     */
    public String recarregarEnergiaPlayer() throws EmptyCollectionException {

        Player player = currentPlayer;
        int connectorName;

        Actions actions = new Actions();

        System.out.println("ID do Connector:");
        connectorName = Integer.parseInt(scanner.nextLine());

        Connector connector1 = (Connector) mapa.findConnectorNetwork(connectorName);

        try {
            Interaction interaction = new Interaction(player, LocalTime.MIN, LocalDate.MAX);
            connector1.addInteraction(interaction);
            actions.rechargeEnergyPlayer(player, connector1);

        } catch (EmptyCollectionException ex) {
            turnNextPlayer();
            return "Não foi possivel carregador energia do jogador!\n";

        }
        currentPlayer.setExperiencePoints(1000);
        currentPlayer.setLevel(currentPlayer.getExperiencePoints());
        turnNextPlayer();
        return "Energia do jogador carregada com sucesso!\n";

    }

    public String carregarPortal() throws EmptyCollectionException {
        Player player = currentPlayer;
        int id;
        int energia;

        Actions actions = new Actions();

        System.out.println("Id do Portal:");
        id = Integer.parseInt(scanner.nextLine());

        System.out.println("Quantidade de Energia");
        energia = Integer.parseInt(scanner.nextLine());

        Portal portal = (Portal) mapa.findPortalNetwork(id);

        try {
            actions.rechargePortal(player, portal, energia);
        } catch (NoSuchElementException ex) {
            turnNextPlayer();
            return "\nNão foi possivel carregador portal!";

        }
        currentPlayer.setExperiencePoints(1000);
        currentPlayer.setLevel(currentPlayer.getExperiencePoints());
        turnNextPlayer();
        return "\nPortal carregador com sucesso!";

    }

    /**
     *
     * Recharges a portal with a certain amount of energy.
     *
     * @return a String message indicating the success or failure of the action
     *
     * @throws EmptyCollectionException if there are no more players in the game
     */
    public String conquistarPortal() throws EmptyCollectionException {
        Player player = currentPlayer;
        int id;
        Actions actions = new Actions();

        System.out.println("id do Portal: ");
        id = Integer.parseInt(scanner.nextLine());

        Portal portal = (Portal) mapa.findPortalNetwork(id);

        try {
            actions.conquerPortal(player, portal);

        } catch (NoSuchElementException ex) {
            turnNextPlayer();
            return "\nPortal não foi conquistado !";

        }
        currentPlayer.setExperiencePoints(1000);
        currentPlayer.setLevel(currentPlayer.getExperiencePoints());
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

    /**
     *
     * Allows the user to change a player's team.
     *
     * @return a string indicating whether the operation was successful or not.
     */
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

    /**
     *
     * @return a string indicating whether the route was successfully added or
     * not.
     * @throws NoSuchElementException if either of the specified locations
     * cannot be found on the map.
     */
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

    /**
     *
     * Removes a player from the game.
     *
     * @return a string indicating whether the operation was successful or not
     *
     * @throws EmptyCollectionException if the player list is empty
     */
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

    /**
     *
     * Adds a new player to the game with the given name and team.
     *
     * @return a message indicating whether the player was added successfully or
     * not
     */
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
                    mapa.exportConnectorsToJson();
                    mapa.exportPortalsToJson();
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
                    mapa.getConnectors();
                    break;
                }
                case 5: {
                    mapa.exportConnectorsToJson();
                    break;
                }
                case 0: {
                    exit = true;
                }

            }

        }

    }

    /**
     *
     * Allows editing of a Connector in the game map by changing its energy,
     * cooldown, and location.
     *
     * @return a message indicating whether the operation was successful or not
     */
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

        Local connector = mapa.findConnectorNetwork(id);
        try {
            mapa.editConnector((Connector) connector, id, energy, cooldown, latitude, longitude);
        } catch (NoSuchElementException ex) {
            return "\nO Connector que pretende editar não existe!";

        }
        return "\nO connector foi editado com sucesso!";

    }

    /**
     *
     * Remove a Connector from the map network.
     *
     * @return a string message indicating if the Connector was successfully
     * removed or not.
     *
     * @throws EmptyCollectionException if the map network is empty.
     */
    public String removerConnector() throws EmptyCollectionException {
        int id;

        System.out.println("id: ");
        id = Integer.parseInt(scanner.nextLine());

        Connector connector = (Connector) mapa.findConnectorNetwork(id);

        try {
            mapa.removerConnector(connector);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel remover o connector!";

        }
        return "\nO connector foi removido com sucesso!";

    }

    /**
     *
     * Método para criar um novo Connector.
     *
     * @return uma mensagem informando se o connector foi criado com sucesso ou
     * não.
     */
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
            mapa.addConnector(connector);
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
                    mapa.getPortals();
                    break;
                }
                case 5: {
                    mapa.exportPortalsToJson();
                }
                case 0: {
                    exit = true;
                }

            }

        }

    }

    /**
     *
     * Edita um portal existente no mapa.
     *
     * @return uma mensagem indicando se o portal foi editado com sucesso ou
     * não.
     */
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

        Portal portal = (Portal) mapa.findLocalNetwork(id);

        try {
            mapa.editPortal(portal, id, name, maxEnergy, energy, latitude, longitude);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel editar o Portal!";

        }
        return "\nO portal foi editado com sucesso!";
    }

    /**
     * Removes a portal from the network.
     *
     * @return a message indicating the success or failure of the removal
     * operation.
     * @throws EmptyCollectionException if the network is empty and there are no
     * portals to remove.
     */
    public String removerPortal() throws EmptyCollectionException {
        int id;

        System.out.println("id: ");
        id = Integer.parseInt(scanner.nextLine());

        Portal portal = (Portal) mapa.findPortalNetwork(id);

        try {
            mapa.removePortal(portal);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel remover o Portal!";

        }
        return "\nO portal foi removido com sucesso!";

    }

    /**
     * Creates a new portal and adds it to the network.
     *
     * @return a message indicating the success or failure of the creation
     * operation.
     */
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
            mapa.addPortal(portal);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel criar o Portal!";

        }
        return "\nO portal foi criado com sucesso!";
    }

    /**
     * Imports data from a JSON file and adds it to the network and player
     * management system.
     *
     * @return a message indicating the success or failure of the import
     * operation.
     * @throws ParseException if there is an error while parsing the JSON file.
     * @throws EmptyCollectionException if the network or player management
     * system is empty and there is no data to import.
     */
    public String importJson() throws ParseException, EmptyCollectionException {
        ImportJsonFile importJson = new ImportJsonFile();
        try {
            importJson.importLocals(mapa, managementPlayer);
            importJson.importRoute(mapa);
            importJson.importPlayers(managementPlayer);
        } catch (NoSuchElementException ex) {
            return "\nNão foi possivel importar dados!";

        }
        return ("\nDados importados com sucesso!");

    }

    /**
     * Lists all players belonging to a specific team.
     *
     * @throws NoSuchElementException if the user enters an invalid team name or
     * if the team does not have any players.
     */
    private void listPlayersByTeam() {

        String team;

        team = escolherEquipa();
        EnumTeam team1 = EnumTeam.valueOf(team);

        managementPlayer.listPlayersByTeam(team1);
    }

    /**
     * Copies all players in the player management system to a queue.
     */
    public void copyPlayers() {
        Iterator<Player> iter = managementPlayer.getPlayer().iterator();
        while (iter.hasNext()) {
            listPlayers.enqueue(iter.next());
        }
    }

    /**
     * Advances the current player to the next player in the list of players.
     *
     * @throws EmptyCollectionException if there are no players in the list.
     */
    private void turnNextPlayer() throws EmptyCollectionException {
        currentPlayer = (Player) listPlayers.dequeue();
        listPlayers.enqueue(currentPlayer);
    }

    /**
     *
     * Moves the current player to a new location, using the shortest path
     * algorithm and checking if the player can use the path to the destination
     * location. If the player is not in any location, the method first spawns
     * the player in the destination location. If the destination location is
     * not found, the method prints an error message. If the player successfully
     * moves to the new location, the method checks if the destination is a
     * connector, and if so, it applies the appropriate effect to the player's
     * current energy level and adds the player to the connector's last entry
     * list. Finally, the method updates the current player's current location.
     *
     * @throws EmptyCollectionException if the list of players is empty
     */
    private void moverJogador() throws EmptyCollectionException {
        int idLocal;
        int idspawn;

        System.out.println("\nLocais Existentes no jogo: ");
        this.mapa.getPortals();
        System.out.println(" \n ");
        this.mapa.getConnectors();

        if (currentPlayer.getPosicaoAtual() == null) {
            System.out.println("Introduza o local onde quer Spawnar:\n");
            idspawn = Integer.parseInt(scanner.nextLine());
            Local destination1 = mapa.findLocalNetwork(idspawn);

            currentPlayer.setPosicaoAtual(destination1);
            System.out.println("Jogador Spawnado no Local : " + destination1.getId());

        } else {
            System.out.println("O jogador " + currentPlayer.getName() + " já se encontra no Local: " + currentPlayer.getPosicaoAtual());
        }

        System.out.println("Introduza o id para o local onde se pretende mover: ");
        idLocal = Integer.parseInt(scanner.nextLine());
        Local destination2 = mapa.findLocalNetwork(idLocal);

        if (destination2 == null) {
            System.out.println("Local não existe!");
        }
        Local playerPosition = mapa.findLocalNetwork(currentPlayer.getPosicaoAtual().getId());
        Iterator<Local> weight = mapa.ShortestPath(playerPosition, destination2);
        if (weight == null) {
            System.out.println("Não existe caminho para esse local");
        } else {
            Route route = new Route(currentPlayer.getPosicaoAtual(), destination2);
            if ((mapa.getRoutesGiants().contains(route) && currentPlayer.getTeam().equals(EnumTeam.GIANTS))
                    || (mapa.getRoutesSparks().contains(route) && currentPlayer.getTeam().equals(EnumTeam.SPARKS))
                    || (!mapa.getRoutesGiants().contains(route) && mapa.getRoutesSparks().contains(route))) {

                currentPlayer.setPosicaoAtual(destination2);
                if (destination2 instanceof Connector) {

                    for (Connector connector : mapa.listConnectors()) {
                        if (connector.getId() == destination2.getId()) {
                            if (connector.isMina()) {
                                currentPlayer.setCurrentEnergy(currentPlayer.getCurrentEnergy() / 2);
                                System.out.println("Connector minado! Perdeu 50% da energia! \n");
                                System.out.println("Energia atual: " + currentPlayer.getCurrentEnergy());
                            }
                            for (Player player : managementPlayer.listPlayers()) {
                                if (player.getPosicaoAtual() != null) {
                                    if (player.getPosicaoAtual().getId() == currentPlayer.getPosicaoAtual().getId()) {
                                        if (player.getCurrentEnergy() < currentPlayer.getCurrentEnergy()) {
                                            PlayerCooldown playerCooldown = new PlayerCooldown(player, LocalDateTime.now());
                                            connector.getPlayerLastEntryList().addToRear(playerCooldown);
                                        } else {
                                            if (player.getCurrentEnergy() > currentPlayer.getCurrentEnergy()) {
                                                PlayerCooldown playerCooldown = new PlayerCooldown(currentPlayer, LocalDateTime.now());
                                                connector.getPlayerLastEntryList().addToRear(playerCooldown);
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        System.out.println("Nao encontro o destino com o id: " + destination2.getId());

                    }

                }
                System.out.println("Jogador " + currentPlayer.getName() + " moveu-se para local com id: " + destination2.getId());

            }
            System.out.println("Jogado não pode utilizar este caminho!");
        }

    }

}
