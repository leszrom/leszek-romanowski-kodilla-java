package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        System.out.println("7.7 RPS");

        Game game = new Game();
        Player userPlayer = new Player("Player 1");
        Player computerPlayer = new Player("Player 2");
        Arbiter arbiter = new Arbiter();

        game.chooseItem(userPlayer.getInput(), userPlayer);
        game.chooseItem(computerPlayer.getInput(), computerPlayer);

        //"Player" przerobic na interface i dla computerPlayer napisać metodę
        // get input() która losuje item; Napisac class User i class Computer,
        //implements Player;





        boolean end = false;
        while (!end) {

            // Game(new Arbiter(GameMode), new User(GameMode, Item) , new Computer(GameMode, Item))
            //new Item(choice) - can be S, P, or R and have value and name;
            //player.chooseItem(), computer.randomItem();
            //1.  player.chooseName()
            //      player.chooseNumberOfRounds()
            //      player.chooseGameMode()
            //      player.chooseItem()
            //2. game.tableOfItems()
            //      game.menu()

            //3. computer.randomItem();
            //
            //4. arbiter.resultsTable()
            end = true;
        }
    }
}
