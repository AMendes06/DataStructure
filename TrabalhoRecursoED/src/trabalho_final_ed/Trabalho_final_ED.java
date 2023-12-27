/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho_final_ed;

import List.ArrayUnorderedList;
import Enum.EnumPortalState;
import static Enum.EnumPortalState.Neutral;
import static Enum.EnumTeam.GIANTS;
import static Enum.EnumTeam.SPARKS;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Player.ManagementPlayer;
import Player.Player;
import Local.ManagementLocal;
import Player.ManagementPlayer;
import Local.Portal;
import Route.ManagementRoute;
import Import.ImportJsonFile;
import Local.Connector;
import Local.Coordinates;
import Local.Local;
import Local.Ownership;
import Menu.Console;
import Player.Actions;
import static java.lang.System.console;
//import java.security.acl.LastOwnerException;
import java.time.LocalDateTime;
import javax.crypto.interfaces.PBEKey;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Trabalho_final_ED {

    public static void main(String[] args) throws EmptyCollectionException, ParseException, ElementNotFoundException {
//        ManagementPlayer manga = new ManagementPlayer();
//        Actions actions = new Actions();
//        ManagementLocal local = new ManagementLocal();
//        Coordinates coordinates = new Coordinates(503, 304);
//        Coordinates coord = new Coordinates(600, 205);
//        
//
//
//        Connector connector = new Connector(1, 1, 1, coordinates);
//
//        Player jogador1 = new Player("Rickee", 1, 100, GIANTS, 50);
//        Player jogador2 = new Player("Jonny", 2, 50, SPARKS, 50);
//        Player jogador3 = new Player("Rickee", 1, 100, GIANTS, 50);
//        Portal portal1 = new Portal(1, "pedro", 3, 5, coordinates);
//        Portal portal2 = new Portal(2, "Catacumbas", 0, 0, coordinates);
//
//        local.addPortal(portal1);
//        local.addPortal(portal2);
//        
//        
//        
//        ManagementRoute rota1 = new ManagementRoute(local.getLocalNetwork());
//        rota1.addRoute(portal1, portal2, 200);
//        rota1.addRoute(portal1, portal2, 150);
//        System.out.println(rota1.getNetwork());

////        ImportJsonFile i = new ImportJsonFile();
//       ManagementRoute R1 = new ManagementRoute(local.getLocalNetwork());
////       local.PrintNumberEdges();
////        i.importPlayers(manga);
////        i.importLocals(local,manga);
////        local.PrintNumberEdges();
////        i.importRoute(local,R1);
//        
//        Connector connector1 = new  Connector(3, 2, 3, coordinates);
//        
//        local.addLocal(portal1);
//        local.addLocal(connector1);
//        
//        manga.addPlayer(jogador1);
//        manga.addPlayer(jogador2);
//        
//        local.exportPortalsToJson();
//        local.exportConnectorsToJson();
//    
//        manga.printPlayers();
//        manga.exportPlayersToJson();
//         System.out.println(R1.getNetwork().toString());
//        R1.addRoute(portal1, portal2);
//
//        
//        R1.exportRouteToJson();
//        
//    }11
//}
//
//        manga.printPlayers();
//        manga.addPlayer(jogador1);
//
//        manga.printPlayers();
//
//        actions.rechargeEnergyPlayer(jogador1, connector);
//        System.out.println(jogador1.getCurrentEnergy());
//        
//        manga.changePlayerTeam(Jogador2, Giants);
//        
//       
//        manga.printPlayers();
//        manga.printTeam(Giants);
//
//        
//
//         ManamagentPortal Laranja2 = new ManamagentPortal();
//         Portal portal1 = new Portal("Catacumbas", 1923, 2034);
//         Portal portal2 = new Portal("Meley", 0023, 1540);
//         Portal portal3 = new Portal("Nilay", 1032, 5002);
//          
//         Laranja2.addPortal(portal1);
//         Laranja2.addPortal(portal2);
//         Laranja2.addPortal(portal3);
//        
//        
//        
//        System.out.println(portal1.toString());
//        System.out.println(portal2.toString());
//        System.out.println(portal3.toString());
//        
//       Laranja2.removePortal(portal1);
//        
//       System.out.println();  
//       ManamagentLocal portal = new ManamagentLocal();
//       ManamagentLocal porta2 = new ManamagentLocal();
//       
//      Portal portal1 = new Portal(Neutral,1,"Pedro", 100, 150);
//      Portal portal2 = new Portal(Neutral,2, "Tiago", 200, 250);
//      Portal portal3 = new Portal(Neutral,4,"Linda", 300, 350);
//      Portal portal4 = new Portal(Neutral,3, "Rickee", 400, 450);
//      ManamagentRoute routa1 = new ManamagentRoute(portal.getPortalNetwork());
//      
//      portal.addPortal(portal1);
//      portal.addPortal(portal2);
//      portal.addPortal(portal3);
//      portal.addPortal(portal3);
//      
// 
//      
//      routa1.addRoute(portal1, portal3, 150);
//      routa1.addRoute(portal1, portal2, 200);
//      
//    System.out.println(portal.getPortalNetwork().toString());
//        ImportJsonFile i = new ImportJsonFile();
//        ManagementPlayer p1 = new ManagementPlayer();
//        Player player1 = new Player("Joao", 0, 100, Giants, 100);
//        Player player2 = new Player("Miguel", 0, 50, Giants, 150);
//
//        p1.addPlayer(player1);
//
//        ManagementLocal L1 = new ManagementLocal();
//        Actions action = new Actions();
//        L1.addLoca;
//        action.rechargeEnergyPlayer(player2,);
        //System.out.println(1);
        Console console = new Console();

        console.Start();
    }
}
