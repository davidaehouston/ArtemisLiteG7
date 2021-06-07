package artemisProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Game class creates the runnable Project Artemis game.
 * 
 * @author Group 7
 *
 */

public class Game {

	private static final int MINIMUM_PLAYERS = 1;
	private static final int MAXIMUM_PLAYERS = 4;
	private static final int DEFAULT_LUNARCOIN = 250;
	private static final int MINIMUM_LUNARCOIN = 0;
	private static final int PASS_HQ_BONUS = 250;
	private static final int REGULAR_DEVELOPMENT_LIMIT = 2;
	private static final int DEVELOPMENT_LIMIT = 4;

	private static PurchaseableSquare purchasableSquare = new PurchaseableSquare();

	private static List<Player> players = new ArrayList<Player>();
	private static List<String> playerNames = new ArrayList<String>();
	private static List<Square> squares = new ArrayList<Square>();

	private static List<ArtemisSystem> systems = new ArrayList<ArtemisSystem>();
	private static Scanner globalScanner = new Scanner(System.in);

	// Game Scripts
	private static final String START_GAME_TEXT = "Mission brief loading...\n\n" + "Welcome to Artemis Lite!\n\n"
			+ "We aim to push the boundaries of space exploration,"
			+ "science and technology as we enter a new era of lunar exploration.\n\n"
			+ "In 2024 we aim to land the next man & first woman on the moon.\n\n"
			+ "To do so we need your help to develop all systems.\n\n" + "We are going, and we go together!\n\n"
			+ "Ad Lunam!\n";

	private static final String GAME_RULES = "Please read the following rules carefully..\n\n1. To play the game"
			+ " each player takes turns to move around the board,\nwhenever they land on a square they are presented"
			+ " with options that can be utilised, in the form of a menu.\n"
			+ "\n2. If you land on a square that has not yet been purchased, you are given the option to\ndo so, if"
			+ " you choose not to purchase and are playing in multiplayer, you are then able to offer the square to another player.\n"
			+ "\n3. Should you land on a square that has been purchased, the square owner, will decide whether"
			+ " you should pay charges.\n"
			+ "\n4. When you land on or pass Headquarters you will be allocated more resources in the form of LunarCoin.\n"
			+ "\n5. Once you have purchased all purchasable squares in a system you become the system owner, you can then develop those "
			+ "squares, every square begins at level 0 and is fully developed at level 4\nthe final development is more expensive than "
			+ "the rest, with every increase in development comes an increase in fine cost to those who land there.\n"
			+ "\n6. In order to complete the mission, all systems must be fully developed & primed for launch.\n"
			+ "\n7. Should any player decide to quit or if a player's LunarCoin falls into negative balance (Less than 0),"
			+ " the mission will be aborted!\n\n" + "\nGood luck in your mission!\n\n";

	private static final String GAME_EPILOGUE = "\nCongratulations Team Artemis!!\n\n"
			+ "You have come through thick and thin & successfully developed all systems needed for mission launch! With these successes,\n"
			+ "NASA and our associates are ready for the events that come next. \n" + "\n"
			+ "NEWS COVERAGE OF THE EVENTS:\n"
			+ "\nIn 2021 - 'NASA SENDS SUPPLIES TO SPACE': After a year that many have struggled with thanks to the COVID-19 pandemic, \n"
			+ "NASA has successfully able to deliver the first Commercial Lunar Payload delivery to the lunar surface, helping pave \n"
			+ "the way for our human explorers! We keep our eyes on the skies as we eagerly anticipate what comes next for Project Artemis!\n"
			+ "\nIn 2022 - 'ARTEMIS I HEADS FOR THE STARS': The Artemis I has launched today for its maiden flight around Earth. The uncrewed \n"
			+ "rocket will undergo extreme training to validate its performance and re-enter earth at a temperature of nearly 5,000 degrees \n"
			+ "Fahrenheit. We'll stay hot on the heels of the story as more details emerge...\n"
			+ "\nIn 2023 - 'NASA ASTRONAUTS TO SET THE RECORD FOR FARTHEST HUMAN TRAVEL FROM EARTH': After last months successful Power and \n"
			+ "Propulsion Element (PPE) and Habitation and Logistics Outpost (HALO) launches, NASA astronauts will travel farther than any \n"
			+ "other astronaut before them by testing deep space communications. Our fingers are crossed that they don't have to ask for \n"
			+ "directions!\n"
			+ "\nIn 2024 - 'MAN AND WOMAN TO MOONWALK TOGETHER': Today, we witness history being made. After the success of Artemis I and \n"
			+ "Artemis II, the crew of the Orion left Earth two weeks ago to once again travel to orbit the Moon - however today, the crew\n"
			+ "has gone further than ever before. Having boarded the Human Landing System, our male and female astronaut has descended to \n"
			+ "the lunar surface and stepped onto the lunar desert, marking the first time in history a woman has walked on the surface \n"
			+ "of the Moon and humanity's return since 19th December 1972. Project Artemis has been a tremendous success! We thank \n"
			+ "the President of the USA, the Congress, the American taxpayers, the space industry and most importantly, \n"
			+ "you - the players who could make this happen. Your names will be remembered forever! Here's to our next greatest leap, \n"
			+ "one day, humans will explore the surface of Mars. Ad lunam!\n";

	/**
	 * Main method which calls the playGame method and closes the scanner when the
	 * user selects to stop playing.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		playGame();
		globalScanner.close();
	}

	/**
	 * Enables a new game to be set up by completely resetting any data stored in
	 * arrays or within the scanner before displaying the game introduction. After
	 * the introduction, the user may read the game instructions and register the
	 * number of players they wish to play with before calling the takeTurn method.
	 */

	public static void playGame() {
		players.removeAll(players);
		squares.removeAll(squares);
		playerNames.removeAll(playerNames);
		globalScanner.reset();
		writeText(START_GAME_TEXT);
		displayRules();
		readInAndPopulateArray();
		registerPlayers();
		takeTurn();
	}

	/**
	 * Styles system output text, emulating a user typing to screen when a String of
	 * text is passed in. Used to replace many instances of 'system.out.println'.
	 * 
	 * @param text
	 */

	public static void writeText(String text) {
		Random r = new Random();
		for (int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			try {
				Thread.sleep(r.nextInt(72));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Provides the option to display game rules to user during the game
	 * introduction when called by the PlayGame method.
	 */

	public static void displayRules() {
		writeText("\nWould you like to see the game instructions before starting your mission? Please enter (Y/N).\n");

		String userOption;
		userOption = globalScanner.next();

		if (userOption.equalsIgnoreCase("Y") || (userOption.equalsIgnoreCase("yes"))) {
			writeText(GAME_RULES);
		} else if (userOption.equalsIgnoreCase("N") || (userOption.equalsIgnoreCase("no"))) {

		} else {
			System.out.println(
					"This is Ground Control. Your circuit's dead, there's something wrong. Try that input again.");
			displayRules();
		}
	}

	/**
	 * Enables game flexibility by tailoring the game based on the data input via a
	 * CSV. After reading in the CSV, this method parses data to populate various
	 * class arrays such as 'systems' and 'squares'. It distinguishes blank squares
	 * (squares where players can't make a purchase) from purchasable squares and
	 * sets each square's unique attributes before adding it to an array.
	 */

	public static void readInAndPopulateArray() {
		String arrayInfo;
		String[] stats;
		Set<String> aSystems = new HashSet<String>();

		try {
			FileReader fileReader = new FileReader(new File("artemisSquares.csv"));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();
			arrayInfo = bufferedReader.readLine();
			do {
				stats = arrayInfo.split(",");

				aSystems.add(stats[3].trim());

				arrayInfo = bufferedReader.readLine();
			} while (arrayInfo != null);
			fileReader.close();
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, CSV file missing");
		} catch (IOException e) {
			System.out.println("Input/Output error");
		}

		for (String aSystem : aSystems) {
			ArtemisSystem artemisSystem = new ArtemisSystem();
			artemisSystem.setSystemName(aSystem);
			systems.add(artemisSystem);
		}

		try {
			FileReader fileReader = new FileReader(new File("artemisSquares.csv"));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();
			arrayInfo = bufferedReader.readLine();
			do {
				PurchaseableSquare purchasableSquare = new PurchaseableSquare();
				BlankSquare blankSquare = new BlankSquare();
				stats = arrayInfo.split(",");
				if (stats[0].equalsIgnoreCase("B")) {
					blankSquare.setSquareState(stats[0].trim());
					blankSquare.setSquareName(stats[1].trim());
					for (ArtemisSystem system : systems) {
						if (system.getSystemName().equalsIgnoreCase(stats[3].trim())) {
							blankSquare.setSystemName(system);
						}
					}
					squares.add(blankSquare);
				} else if (stats[0].equalsIgnoreCase("P")) {
					purchasableSquare.setSquareState(stats[0].trim());
					purchasableSquare.setSquareName(stats[1].trim());
					purchasableSquare.setSquareValue(Integer.parseInt(stats[2]));

					for (ArtemisSystem system : systems) {
						if (system.getSystemName().equalsIgnoreCase(stats[3].trim())) {
							purchasableSquare.setSystemName(system);
						}
					}
					purchasableSquare.setRegularDevelopmentPrice(Integer.parseInt(stats[4]));
					purchasableSquare.setFinalDevelopmentPrice(Integer.parseInt(stats[5]));
					purchasableSquare.setLevel0FineCost(Integer.parseInt(stats[6]));
					purchasableSquare.setLevel1FineCost(Integer.parseInt(stats[7]));
					purchasableSquare.setLevel2FineCost(Integer.parseInt(stats[8]));
					purchasableSquare.setLevel3FineCost(Integer.parseInt(stats[9]));
					purchasableSquare.setLevel4FineCost(Integer.parseInt(stats[10]));

					squares.add(purchasableSquare);

				} else {
					System.out.println("Error in CSV file");
				}
				arrayInfo = bufferedReader.readLine();
			} while (arrayInfo != null);
			fileReader.close();
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, CSV file missing");
		} catch (IOException e) {
			System.out.println("Input/Output error");
		}
	}

	/**
	 * Allows the user to register the number of players they wish to play with
	 * between 1 - 4 and enter each players name. No two players can have the same
	 * name, numbers within their name and a player name may not be a blank input.
	 * If their name is accepted, it sets each player into the game with a default
	 * LunarCoin balance.
	 * 
	 * @throws InputMismatchException
	 * @throws IllegalArgumentException
	 */

	public static void registerPlayers() throws InputMismatchException, IllegalArgumentException {
		Random randomNumGenerator = new Random();
		int randomNumber;
		String registeredMessage = null;

		try {
			writeText("\nHow many players would you like to register between " + MINIMUM_PLAYERS + " and "
					+ MAXIMUM_PLAYERS + "?\n");
			int playerCountTotal = globalScanner.nextInt();
			if (playerCountTotal >= MINIMUM_PLAYERS && playerCountTotal <= MAXIMUM_PLAYERS) {
			} else {
				System.out.println("Player number error - player number must be be set between 1 and 4 (inclusive).");
				registerPlayers();
			}
			int counter = 1;
			String t = globalScanner.nextLine();

			for (int loop = counter; loop <= playerCountTotal; loop++) {

				try {
					while (playerNames.size() != playerCountTotal) {
						writeText("\nWhat is the name of Player " + counter + "?\n");
						String playerName = globalScanner.nextLine().trim();
						playerName = playerName.toUpperCase().substring(0, 1) + playerName.toLowerCase().substring(1);

						if (playerName.contains("1") || playerName.contains("2") || playerName.contains("3")
								|| playerName.contains("4") || playerName.contains("5") || playerName.contains("6")
								|| playerName.contains("7") || playerName.contains("8") || playerName.contains("9")
								|| playerName.contains("0")) {
							System.out.println(
									"HQ understands that you are eager, but we do not accept inputs with numbers.\nPlease try again.");
						} else {
							randomNumber = randomNumGenerator.nextInt(9);
							switch (randomNumber) {
							case 0:
								registeredMessage = "reporting for duty!";
								break;
							case 1:
								registeredMessage = "get ready to rock and roll!";
								break;
							case 2:
								registeredMessage = "say farewell to your loved ones as you begin your lunar mission!";
								break;
							case 3:
								registeredMessage = "HQ welcomes you to the Project Artemis team.";
								break;
							case 4:
								registeredMessage = "you are cleared for mission launch.";
								break;
							case 5:
								registeredMessage = "Ad Lunam!";
								break;
							case 6:
								registeredMessage = "thank you for your service.";
								break;
							case 7:
								registeredMessage = "hope you aren't afraid of heights...";
								break;
							case 8:
								registeredMessage = "we'll be in touch to get your space-suit size.";
								break;
							}

							// if array.size = 0
							if (players.size() < MINIMUM_PLAYERS) {
								// Accepted - add playerName to array
								writeText(playerName + " is now Player " + counter + " - " + registeredMessage + "\n");
								Player player = new Player();
								player.setPlayerName(playerName);
								player.setLunarCoinBalance(DEFAULT_LUNARCOIN);
								players.add(player);
								playerNames.add(playerName);
								// array number incremented to 1.
								counter++;
								// counter of players incremented.
							} else if (players.size() >= 1) {

								if (playerNames.contains(playerName)) {
									System.out.println(
											"There can't be multiple space heroes with the same name. Enter another name.");
								}

								else if (!playerNames.contains(playerName)) {
									writeText(playerName + " is now Player " + counter + " - " + registeredMessage
											+ "\n");
									Player player = new Player();
									player.setPlayerName(playerName);
									player.setLunarCoinBalance(DEFAULT_LUNARCOIN);
									players.add(player);
									playerNames.add(playerName);
									counter++;
								}
							}
						}
					}
				} catch (StringIndexOutOfBoundsException | StackOverflowError blankNameException) {
					System.out.println("Player names cannot be blank. Let's try that again.");
					loop--;
				}
			}
		} catch (InputMismatchException | IllegalArgumentException inputExceptions) {
			globalScanner.nextLine();
			System.out.println("Please input your answer in integer format ('1','2','3','4').");
			registerPlayers();
		}
	}

	/**
	 * Recursive method which allows each player to take their turn in an unending
	 * cycle until the game is over. Each player is offered to take their turn and
	 * when accepted, 'dice' is rolled and the player moves to a new location. An
	 * event may happen depending on which square a player lands on. After this
	 * event (or if nothing happens), the player is shown their main menu to decide
	 * what to do on their turn. When the player has ended their turn via the main
	 * menu, the next player in the players array starts their turn and the process
	 * repeats.
	 */

	public static void takeTurn() {
		for (Player player : players) {
			readyToRoll(player);
			adjustBoardPosition(player, rollDice(player));
			mainMenu(player);
		}
		takeTurn();
	}

	/**
	 * Per customer requirements, the player must be offered to take their turn.
	 * This method repeatedly asks the current player if they are willing to take
	 * their turn until they are ready.
	 * 
	 * @param player
	 */

	public static void readyToRoll(Player player) {
		String yesOrNo = null;
		writeText("\n" + player.getPlayerName() + ", are you ready to roll? (Y/N)\n");
		yesOrNo = globalScanner.next();
		if (yesOrNo.equalsIgnoreCase("N") || yesOrNo.equalsIgnoreCase("No")) {
			readyToRoll(player);
		} else if (yesOrNo.equalsIgnoreCase("Y") || yesOrNo.equalsIgnoreCase("Yes")) {

		} else {
			writeText("We have lost your signal " + player.getPlayerName() + ", please try again...");
			readyToRoll(player);
		}
	}

	/**
	 * Throws a Random number between 2-12 for a dice outcome and lets the player
	 * who has been passed into the method know the number of this outcome. Each
	 * dice outcome increments a counter for the total number of squares they have
	 * travelled which is presented in playerAwards method at the end of the game.
	 * 
	 * @param player
	 * @return
	 */

	public static int rollDice(Player player) {
		Random dice = new Random();
		int diceOutcome = dice.nextInt(11);
		diceOutcome+=2;
		writeText("\n" + player.getPlayerName() + " has rolled " + diceOutcome + "...");
		player.incrementSquaresTravelled(diceOutcome);
		return diceOutcome;
	}

	/**
	 * The players location is repositioned based on their dice outcome. A number of
	 * events may happen, based on where the player lands: If a player lands on a
	 * "Black Hole" blank square then nothing happens. If a player lands on a square
	 * they own, the system will relay this. If a player lands on an unowned
	 * purchasable square, they will be offered to purchase it. If a player lands on
	 * purchasable square owned by another player, the square owner will be asked if
	 * they would like to fine the player who has landed on their square. If a
	 * player lands on the HQ square, then they will earn the HQ LunarCoin bonus and
	 * the system will relay this. If a player passes the HQ square then the HQ
	 * LunarCoin bonus will be given and any of the above events may trigger
	 * depending on where the player lands.
	 * 
	 * @param player
	 * @param diceOutcome
	 * @return
	 */

	public static int adjustBoardPosition(Player player, int diceOutcome) {
		int position = player.getCurrentBoardPosition() + diceOutcome;
		int newBoardPosition = 0;

		try {
			if (position >= squares.size() && position < 20 && position < 21) {
				newBoardPosition = position - squares.size();
				player.setCurrentBoardPosition(newBoardPosition);
				player.setHasPassedHQ(true);
				if (squares.get(newBoardPosition).getSquareName().equalsIgnoreCase("Black Hole".trim())) {
					passHQ(player, newBoardPosition);
					writeText(" before a close encounter with a Black Hole.  Rest up and do nothing.\n");
				} else if (newBoardPosition == 0) {
					writeText("and has returned to " + squares.get(newBoardPosition).getSquareName());
					passHQ(player, newBoardPosition);
				} else {
					passHQ(player, newBoardPosition);
					writeText("before landing on " + squares.get(newBoardPosition).getSquareName() + " in the "
							+ squares.get(newBoardPosition).getSystemName().getSystemName() + " System.");
					PurchaseableSquare pSquare = null;
					pSquare = (PurchaseableSquare) squares.get(newBoardPosition);
					if (pSquare.getSquareOwner().equals(player)) {
						writeText("\nYou are the current owner of " + squares.get(newBoardPosition).getSquareName()
								+ ".\n");
					}
				}
			} else if (position < squares.size()) {
				newBoardPosition = position;
				player.setCurrentBoardPosition(newBoardPosition);
				if (squares.get(newBoardPosition).getSquareName().equalsIgnoreCase("Black Hole".trim())) {
					writeText("\n" + player.getPlayerName()
							+ ", you have had a close encounter with a Black Hole.  Rest up and do nothing.\n");
				} else {
					writeText("and landed on " + squares.get(newBoardPosition).getSquareName() + " in the "
							+ squares.get(newBoardPosition).getSystemName().getSystemName() + " System.");
					PurchaseableSquare pSquare = null;
					pSquare = (PurchaseableSquare) squares.get(newBoardPosition);
					if (pSquare.getSquareOwner().equals(player)) {
						writeText("\nYou are the current owner of " + squares.get(newBoardPosition).getSquareName()
								+ ".\n");
					}
				}
			} else if (position == 20) {
				newBoardPosition = 0;
				player.setCurrentBoardPosition(newBoardPosition);
				player.setHasPassedHQ(true);
				writeText("and landed on " + squares.get(newBoardPosition).getSquareName() + " in the "
						+ squares.get(newBoardPosition).getSystemName().getSystemName() + " System");
				passHQ(player, newBoardPosition);
			} else if (position == 21) {
				newBoardPosition = 1;
				player.setCurrentBoardPosition(newBoardPosition);
				player.setHasPassedHQ(true);
				if (newBoardPosition == 0) {
					writeText("and has returned to " + squares.get(newBoardPosition).getSquareName());
					passHQ(player, newBoardPosition);
				} else {
					passHQ(player, newBoardPosition);
					writeText("before landing on " + squares.get(newBoardPosition).getSquareName() + " in the "
							+ squares.get(newBoardPosition).getSystemName().getSystemName() + " System.");
					PurchaseableSquare pSquare = null;
					pSquare = (PurchaseableSquare) squares.get(newBoardPosition);
					if (pSquare.getSquareOwner().equals(player)) {
						writeText("\nYou are the current owner of " + squares.get(newBoardPosition).getSquareName()
								+ ".\n");
					}
				}
			}
		} catch (NullPointerException nullPointerException) {
		}
		checkBoardStatus(player, squares.get(newBoardPosition));

		return newBoardPosition;
	}

	/**
	 * Method checks if the player passed into the method owns the square they have
	 * landed on. If they do not and the square is a purchasable square, the
	 * payCharges method is called.
	 * 
	 * @param player
	 * @param square
	 */

	public static void checkBoardStatus(Player player, Square square) {
		if (square.getSquareState().equalsIgnoreCase("P")) {
			purchasableSquare = (PurchaseableSquare) square;
			if (purchasableSquare.isOwned() == false) {
				purchaseSquare(purchasableSquare, player, square.getSystemName());
			}
			if (purchasableSquare.isOwned() == true && purchasableSquare.getSquareOwner() != player
					&& player.isAlreadyRolled() == true) {

			} else if (purchasableSquare.isOwned() == true && purchasableSquare.getSquareOwner() != player) {
				payCharges(player, purchasableSquare.getSquareOwner(), purchasableSquare,
						purchasableSquare.getDevelopmentLevel());
			}
		}
	}

	/**
	 * Method checks to see if the game winning or game losing criteria has been
	 * met. The game ends with a loss if any players have a negative (<0) LunarCoin
	 * balance after being fined, purchasing a square or developing a square. If all
	 * purchasable squares are developed to the maximum level then the game ends
	 * with a victory for all players.
	 */

	public static void checkGameConditions() {
		int fullyDeveloped = 0;
		int purchasableSquares = 0;

		for (Square square : squares) {
			if (square.getSquareState().equalsIgnoreCase("P")) {
				purchasableSquares++;
				purchasableSquare = (PurchaseableSquare) square;
				if (purchasableSquare.getDevelopmentLevel() == DEVELOPMENT_LIMIT) {
					fullyDeveloped++;
				}
			}
		}
		if (fullyDeveloped == purchasableSquares) {
			endGameWin();
		}

		for (Player player : players) {
			if (player.getLunarCoinBalance() < MINIMUM_LUNARCOIN) {
				endGameLose();
			}
		}
	}

	/**
	 * Provides the player who is passed into the method with an opportunity to
	 * purchase the square they have landed on. If the square owner is null for the
	 * square the player has landed on, then it will let player know the square is
	 * uncharted territory and can be purchased: If a player can afford the purchase
	 * and agrees to purchase then they are registered as the square owner for the
	 * rest of the game. If a player cannot afford the square, but still agrees to
	 * the purchase, the game ends. If the player rejects the opportunity to
	 * purchase the square, then another player within the players array may agree
	 * to purchase the square instead.
	 * 
	 * @param purchaseableSquare
	 * @param player
	 * @param squareSystem
	 */

	public static void purchaseSquare(PurchaseableSquare purchaseableSquare, Player player,
			ArtemisSystem squareSystem) {

		writeText("\n\n" + player.getPlayerName() + ", your current LunarCoin balance is : "
				+ player.getLunarCoinBalance());
		System.out.println();
		writeText(purchaseableSquare.getSquareName() + " is available to purchase for "
				+ purchaseableSquare.getSquareValue() + " LunarCoin.");
		PurchaseableSquare otherSystemSquare = null;

		for (Square pSquare : squares) {
			if (pSquare.getSquareState().equalsIgnoreCase("p") && pSquare.getSystemName().equals(squareSystem)
					&& !pSquare.equals(purchaseableSquare)) {
				otherSystemSquare = (PurchaseableSquare) pSquare;
			}
		}
		try {
			if (!otherSystemSquare.getSquareOwner().getPlayerName().equals(null)) {
				writeText("\nThe other square in this system is - " + otherSystemSquare.getSquareName()
						+ " and it is owned by - " + otherSystemSquare.getSquareOwner().getPlayerName());
			}
		} catch (NullPointerException nullPointerException) {
			writeText("\nThis system is uncharted territory.");
		}
		writeText("\nWould you like to purchase this square? (Y/N)?\n");

		String userInput = globalScanner.next();

		if (userInput.equalsIgnoreCase("Y") || (userInput.equalsIgnoreCase("Yes"))) {
			player.deductLunarCoin(purchaseableSquare.getSquareValue());
			purchaseableSquare.setOwned(true);
			purchaseableSquare.setSquareOwner(player);

			player.incrementNumberOfSquaresOwned();
			player.addToPlayerSquares(purchaseableSquare);

			int squareSystemCount = 0;

			for (PurchaseableSquare pSquare : player.playerSquares) {
				if (pSquare.getSystemName().equals(squareSystem)) {
					squareSystemCount++;
				}
			}

			if (squareSystemCount >= 2) {
				squareSystem.setSystemOwner(player);
			}

			if (player.getLunarCoinBalance() >= 0) {
				writeText("\nUpdated LunarCoin balance : " + player.getLunarCoinBalance());
				writeText("\nA great advancement has been made! You have purchased "
						+ purchaseableSquare.getSquareName() + " for " + purchaseableSquare.getSquareValue() + "!\n");
				checkGameConditions();
			}

			if (player.getLunarCoinBalance() < 0) {
				writeText("Emergency! " + player.getPlayerName() + " has purchased "
						+ purchaseableSquare.getSquareName() + " for " + purchaseableSquare.getSquareValue()
						+ " LunarCoin and cannot afford this!\n");
				player.incrementNumberOfSquaresOwned();
				writeText("\nMission aborting in 3...");
				writeText("\nMission aborting in 2...");
				writeText("\nMission aborting in 1...\n");
				checkGameConditions();
			}

		} else if (userInput.equalsIgnoreCase("N") || (userInput.equalsIgnoreCase("No"))) {
			try {
				if (players.size() > 1) {
					writeText("\nWould another player wish to purchase " + purchaseableSquare.getSquareName() + " for "
							+ purchaseableSquare.getSquareValue() + " LunarCoin? (Y/N)\n");
					String userOption = globalScanner.next();

					if (userOption.equalsIgnoreCase("Y") || userOption.equalsIgnoreCase("Yes")) {
						writeText("Please pick one of the following players (Example '1','2' or '3')");
						player.setAlreadyRolled(true);

						for (Player p : players) {
							if (p.getPlayerName() != player.getPlayerName()) {
								writeText("\n" + (players.indexOf(p) + 1) + ": " + p.getPlayerName() + "\n");
							}
						}
						int playerChosen = globalScanner.nextInt() - 1;
						Player anotherPlayer = players.get(playerChosen);
						purchaseSquare(purchaseableSquare, anotherPlayer, squareSystem);
					} else if (userOption.equalsIgnoreCase("N") || userOption.equalsIgnoreCase("No")) {
					} else {
						System.out.println("Input not recognised - let's try that again.");
						purchaseSquare(purchaseableSquare, player, squareSystem);
					}
				} else if (players.size() == 1) {
				} else {
					// purchaseSquare(purchaseableSquare, player, squareSystem);
				}
			} catch (IndexOutOfBoundsException | InputMismatchException indexOutOfBounds) {
				System.out.println("Input not recognised - let's try that again.");
				purchaseSquare(purchaseableSquare, player, squareSystem);
			}
		}

		else {
			System.out.println("Input not recognised - let's try that again.");
			purchaseSquare(purchaseableSquare, player, squareSystem);
		}

	}

	/**
	 * Offers the square owner an opportunity to accept or reject a fine for another
	 * player landing on their purchased square. The fine amount is dependent on the
	 * square development level, increasing in value from least expensive (level 1)
	 * to most expensive (level 4). If a square owner accepts the fine, the fine
	 * value is deducted from the player who landed on the squares LunarCoin
	 * balance. If a square owner rejects the square fine then no changes to the
	 * players balance is made.
	 * 
	 * @param player
	 * @param owner
	 * @param square
	 * @param squareDevelopment
	 */

	public static void payCharges(Player player, Player owner, PurchaseableSquare square, int squareDevelopment) {
		Random randomNumGenerator = new Random();
		String userOption;
		int randomNumber;
		int fineCost = -1;

		if (squareDevelopment == 0) {
			fineCost = purchasableSquare.getLevel0FineCost();
		} else if (square.getDevelopmentLevel() == 1) {
			fineCost = purchasableSquare.getLevel1FineCost();
		} else if (square.getDevelopmentLevel() == 2) {
			fineCost = purchasableSquare.getLevel2FineCost();
		} else if (square.getDevelopmentLevel() == 3) {
			fineCost = purchasableSquare.getLevel3FineCost();
		} else if (square.getDevelopmentLevel() == 4) {
			fineCost = purchasableSquare.getLevel4FineCost();
		}
		writeText("\n\n" + owner.getPlayerName() + ", " + player.getPlayerName() + " has "
				+ player.getLunarCoinBalance() + " LunarCoin. They have landed on " + purchasableSquare.getSquareName()
				+ " and owes you " + fineCost + " LunarCoin. \nDo you want to accept the fine - (Y/N)\n");

		userOption = globalScanner.next();

		if (userOption.equalsIgnoreCase("y") || userOption.equalsIgnoreCase("Yes")) {
			writeText("\n" + player.getPlayerName() + " has paid " + owner.getPlayerName() + "  - " + fineCost
					+ " LunarCoin.\n");
			player.deductLunarCoin(fineCost);
			owner.addLunarCoin(fineCost);
			player.incrementAcceptedFineCount();
			randomNumber = randomNumGenerator.nextInt(9);
			switch (randomNumber) {
			case 0:
				writeText("Your money will be used to teach astronauts to moonwalk.\n");
				break;
			case 1:
				writeText("Your money will be used to grow astroturf.\n");
				break;
			case 2:
				writeText("Your money will be used to remove space ants from the communications antenna.\n");
				break;
			case 3:
				writeText("Your money will be used to conduct surveillance on the man on the moon.\n");
				break;
			case 4:
				writeText("Your money will be used to rennovate the space rockets attic.\n");
				break;
			case 5:
				writeText("Your money will be used to rescue WALL-E.\n");
				break;
			case 6:
				writeText("Your money will be used to harvest moon rocks.\n");
				break;
			case 7:
				writeText("Your money will be used to shed some light on dark matter.\n");
				break;
			case 8:
				writeText("Your money will be used to polish telescopes.\n");
				break;
			}
			checkGameConditions();
		} else if (userOption.equalsIgnoreCase("n") || userOption.equalsIgnoreCase("No")) {
			writeText("\nNo selected: " + owner.getPlayerName() + " has let you off easy!\n");
			player.incrementRefusedFineCount();
		} else {
			writeText("Input not recognised.");
			payCharges(player, owner, purchasableSquare, purchasableSquare.getDevelopmentLevel());
		}

	}

	/**
	 * Method adds the PASS_HQ_BONUS to the player's LunarCoin balance when they
	 * pass or land on the HQ square depending on their position in the game after
	 * the dice outcome.
	 * 
	 * @param player
	 * @param position
	 */

	public static void passHQ(Player player, int position) {
		int lunarCoin = player.getLunarCoinBalance() + PASS_HQ_BONUS;
		player.setLunarCoinBalance(lunarCoin);
		if (position == 0) {
			writeText(", collecting " + PASS_HQ_BONUS + " LunarCoin.\n");
		} else {
			writeText(" and passed HQ, collecting " + PASS_HQ_BONUS + " LunarCoin...");
		}
	}

	/**
	 * Presents the player's main menu for players to perform various actions.
	 * Options include: develop the players' own purchased squares, display the game
	 * progress to understand what needs purchased or developed, end the players'
	 * turn or quit the game.
	 * 
	 * 
	 * @param player
	 * @throws InputMismatchException
	 * @throws InputMismatchException
	 */

	public static void mainMenu(Player player) throws InputMismatchException, InputMismatchException {
		System.out.println("\n" + player.getPlayerName().toUpperCase() + "'S MAIN MENU" + " - (LunarCoin Balance: "
				+ player.getLunarCoinBalance() + ")");
		System.out.println("To select a menu option, enter a number... (For example, press '1' for 'Develop Menu')");
		System.out.print("\n1: Develop Menu\n2: Display Current Game Progress \n3: End Turn \n4: Quit Game\n");
		try {
			int userOption = 0;
			boolean proceed = false;
			if (globalScanner.hasNextInt()) {
				userOption = globalScanner.nextInt();
			}
			while (proceed != true) {
				switch (userOption) {
				case 1:
					developMenu(player);
					proceed = true;
					break;
				case 2:
					displayCurrentProgress(player);
					proceed = true;
					break;
				case 3:
					displayEndTurn(player);
					proceed = true;
					break;
				case 4:
					System.out.println("Quitting...");
					quitGame(player);
					proceed = true;
					break;
				default:
					writeText("\nHQ doesn't understand your input, maybe it was intercepted by Aliens."
							+ "\nTry entering a number between 1-4 (inclusive) this time.\n");
					userOption = globalScanner.nextInt();
				}
			}
		} catch (InputMismatchException | IllegalArgumentException inputExceptions) {
			globalScanner.nextLine();
			mainMenu(player);
		}
	}

	/**
	 * An option a player can select from their main menu. The method displays the
	 * games current progress to give players an idea of what squares are owned,
	 * what each squares development level is and what else needs to be purchased in
	 * what system to win the game.
	 * 
	 * @param player
	 */

	public static void displayCurrentProgress(Player player) {
		int purchasableSquares = 0;
		int unpurchasedSquares = 0;
		System.out.println("\nCurrent Progress: ___________________________\n");
		for (Square square : squares) {
			if (square.getSquareState().equalsIgnoreCase("p")) {
				purchasableSquares++;
			}
		}
		System.out.println("Total Purchasable Squares: " + purchasableSquares);
		System.out.println("Squares owned by player(s): \n");
		for (Player p : players) {
			System.out.println(p.getPlayerName() + ":");
			for (PurchaseableSquare square : p.getPlayerSquares()) {
				System.out.println(square.getSquareName() + " in the " + square.getSystemName().getSystemName()
						+ " system : Development Level: " + square.getDevelopmentLevel());
			}
			System.out.println();
		}
		System.out.println();

		for (Square square : squares) {
			if (square.getSquareState().equalsIgnoreCase("p")) {
				purchasableSquare = (PurchaseableSquare) square;
				if (purchasableSquare.getSquareOwner() == null) {
					unpurchasedSquares++;
				}
			}
		}
		String sqName = "Square Name";
		String sysName = "System Name";
		System.out.println("Purchased Squares Remaining - " + unpurchasedSquares + ":\n");
		System.out.printf("%-30s%-2s\n", sqName, sysName);
		for (Square square : squares) {
			if (square.getSquareState().equalsIgnoreCase("p")) {
				purchasableSquare = (PurchaseableSquare) square;
				if (purchasableSquare.getSquareOwner() == null) {
					System.out.printf("\n%-30s%-2s", purchasableSquare.getSquareName(),
							purchasableSquare.getSystemName().getSystemName() + " system.");
				}
			}
		}
		System.out.println("\n______________________________________________________");
		mainMenu(player);
	}

	/**
	 * An option a player can select from their main menu. When selected, this menu
	 * shows which squares the player owns and which can be developed along with
	 * each squares development level and price. A player may select a square to
	 * develop or return to the main menu. If a square is developed, the development
	 * cost is deducted from the players LunarCoin balance - if it becomes <0 then
	 * the game ends with a loss or if every players' purchased squares are at the
	 * max development level, the game ends with a victory.
	 * 
	 * @param player
	 */

	public static void developMenu(Player player) {
		System.out.println("\n\n" + player.getPlayerName().toUpperCase() + "'S DEVELOP MENU" + " - (LunarCoin Balance: "
				+ player.getLunarCoinBalance() + ")");

		System.out.printf("\n%-5s%-25s%-20s%-22s%-30s\n", " ", "Square Name", "System Name", "Development Level",
				"Cost");

		for (PurchaseableSquare square : player.getPlayerSquares()) {
			if (square.getDevelopmentLevel() < 3) {
				System.out.printf("%-5d%-25s%-20s%-22d%-30d\n", (player.getPlayerSquares().indexOf(square) + 1),
						square.getSquareName(), square.getSystemName().getSystemName(), square.getDevelopmentLevel(),
						square.getRegularDevelopmentPrice());
			} else if (square.getDevelopmentLevel() >= 3) {
				System.out.printf("%-5d%-25s%-20s%-22d%-30d\n", (player.getPlayerSquares().indexOf(square) + 1),
						square.getSquareName(), square.getSystemName().getSystemName(), square.getDevelopmentLevel(),
						square.getFinalDevelopmentPrice());
			}

		}

		writeText("\n\nChoose a Square to develop.\n");
		writeText("Or enter '0' to return to Main Menu\n");

		int developChoice = globalScanner.nextInt();

		try {
			if (developChoice == 0) {
				mainMenu(player);
				developChoice = 0;
			} else if (developChoice > 0) {
				purchasableSquare = player.getPlayerSquares().get(developChoice - 1);

				if (purchasableSquare.getSystemName().getSystemOwner().equals(null)) {
				}

				if (purchasableSquare.getSystemName().getSystemOwner().equals(player)) {
					if (purchasableSquare.getDevelopmentLevel() <= REGULAR_DEVELOPMENT_LIMIT) {
						writeText("\nCongratulations, you have upgraded " + purchasableSquare.getSquareName()
								+ " from level " + purchasableSquare.getDevelopmentLevel() + " to level "
								+ (purchasableSquare.getDevelopmentLevel() + 1) + ".");
						purchasableSquare.incrementDevelopmentLevel();
						player.deductLunarCoin(purchasableSquare.getRegularDevelopmentPrice());
						checkGameConditions();
						developMenu(player);
					} else if (purchasableSquare.getDevelopmentLevel() < DEVELOPMENT_LIMIT
							&& purchasableSquare.getDevelopmentLevel() > REGULAR_DEVELOPMENT_LIMIT) {
						writeText("\nCongratulations, you have fully upgraded " + purchasableSquare.getSquareName()
								+ ". One small " + "step for " + player.getPlayerName()
								+ " one giant leap for Project Artemis!\n");
						purchasableSquare.incrementDevelopmentLevel();
						player.deductLunarCoin(purchasableSquare.getFinalDevelopmentPrice());
						checkGameConditions();
						developMenu(player);
					} else if (purchasableSquare.getDevelopmentLevel() == DEVELOPMENT_LIMIT) {
						writeText("This is already fully developed, hurrah!");
						developMenu(player);
					}
				}
			}
		} catch (NullPointerException nullPointerException) {
			writeText("You must own all purchasable squares in the system before upgrading");

			developMenu(player);
		}
	}

	/**
	 * Shown after a player ends their turn via the Main Menu option. Displays text
	 * to let the player who is passed into method know that their turn has now
	 * ended. Checks game conditions to see if any players LunarCoin balance is <0
	 * before player starts next turn and sets the player back to an unrolled state
	 * for their next turn.
	 * 
	 * @param player
	 */

	public static void displayEndTurn(Player player) {
		writeText(player.getPlayerName() + ", your turn has now ended.\n");
		checkGameConditions();
		player.setAlreadyRolled(false);
	}

	/**
	 * An option a player can select from their main menu. Asks a player to confirm
	 * if they want to quit the game. If a player chooses to keep playing, it
	 * returns to the main menu, otherwise this method ends the game with a loss for
	 * all players.
	 * 
	 * @param player
	 */

	public static void quitGame(Player player) {
		writeText("\n" + player.getPlayerName() + ", are you sure you want to abort the mission? Enter '1' or '2'.");
		System.out.println("\n1: Quit Game\n2: Keep playing...");
		int userOption = globalScanner.nextInt();
		switch (userOption) {
		case 1:
			writeText("This is surely a disaster for mankind...");
			endGameLose();
			break;
		case 2:
			writeText("Exiting the Quit Game option and returning to Main Menu...");
			mainMenu(player);
			break;
		default:
			writeText("Ground control says try that again.");
			quitGame(player);
		}
	}

	/**
	 * Method concludes game with a loss and presents player standings. The user may
	 * choose to restart the game or stop playing. If the player restarts, the
	 * playGame method is called - all data will be cleared and a new game begins.
	 */

	public static void endGameLose() {
		String userOption;
		writeText(
				"\nHumanity's failure to co-operate means that future endeavours to live on the moon will become more challenging than ever before.\n");
		writeText("We have much more to prepare.\n");
		writeText("Who knows when we will be ready to live among the stars...\n");
		System.out.println();

		playerStandings();

		writeText("\nWould you like to play again?\nEnter 'Y' to restart the game, or 'N' to stop playing.\n");
		userOption = globalScanner.next();

		if (userOption.equalsIgnoreCase("n") || userOption.equalsIgnoreCase("No")) {
			writeText("'Thanks for playing!'");

			System.exit(1);
		} else if (userOption.equalsIgnoreCase("y") || userOption.equalsIgnoreCase("Yes")) {
			writeText("Restarting mission...");
			playGame();
		} else {
			writeText("Humanity's fate lies in your hands.. try that again.");
			endGameLose();
		}
	}

	/**
	 * Method concludes game with a victory and the game epilogue and player
	 * standings are presented. The user may choose to restart the game or stop
	 * playing. If the player restarts, the playGame method is called - all data
	 * will be cleared and a new game begins.
	 */

	public static void endGameWin() {
		String userOption;
		writeText(
				"Pushing the boundaries of space exploration, science and technology, humanity has successfully come together to usher\n"
						+ "in a new era of lunar exploration thanks to project Artemis.\n");
		writeText(
				"Countries across the world celebrate your success. You and your colleagues will go down in history as the people who\n"
						+ "helped free humanity from their ties to earth.\n");
		writeText(
				"Humanity will eventually explore regions of the moon never visited before, paving the way for us to delve deeper into\n"
						+ "the reaches of the galaxy with the moon becoming the base for missions to Mars.\n");
		System.out.println();
		writeText("'That's one small step for man, one giant leap for mankind.' - Neil Armstrong");
		System.out.println();
		writeText(GAME_EPILOGUE);
		playerStandings();
		writeText("Do you want to play again?");

		System.out.println("\nEnter 'Y' to play again or enter 'N' to quit...");
		userOption = globalScanner.next();

		if (userOption.equalsIgnoreCase("n") || userOption.equalsIgnoreCase("No")) {
			System.out.println("'Thanks for playing!'");
			System.exit(2);
		} else if (userOption.equalsIgnoreCase("y") || userOption.equalsIgnoreCase("Yes")) {
			System.out.println("Restarting mission... god speed.");
			playGame();
		} else {
			System.out.println("Communications were scrambled, try that again.");
			endGameWin();
		}
	}

	/**
	 * The player standings show each players progress within the game - showing
	 * what each player owned and each owned squares development level along with
	 * end game LunarCoin balance(s). The method also calls the displayAwards method
	 * to provide more context on player performance.
	 */

	public static void playerStandings() {
		System.out.println("\nPlayer Standings");
		System.out.println("------------------------------------------------------------------------------");

		for (Player player : players) {
			writeText(player.getPlayerName() + "________________________________");
			writeText("Squares Purchased: " + player.getNumberOfSquaresOwned() + "\n");

			for (PurchaseableSquare pSquare : player.getPlayerSquares()) {
				if (pSquare.getSquareOwner().getPlayerName() == player.getPlayerName()) {
					writeText("> " + pSquare.getSquareName() + " - Development Level: " + pSquare.getDevelopmentLevel()
							+ "\n");
				}
			}

			writeText("\nEnd Game LunarCoin Balance: " + player.getLunarCoinBalance() + "\n\n");
		}
		displayAwards();
	}

	/**
	 * Method displays several player awards based on how players engaged with the
	 * game. E.g. Most squares travelled, most fines refused. Called only by
	 * playerStandings method at end of game.
	 */

	public static void displayAwards() {
		int highestLunarCoin = 0;
		int lowestLunarCoin = 100000;
		int acceptedFineCount = 0;
		int refusedFineCount = 0;
		int mostSquaresTravelled = 0;
		int fewestSquaresTravelled = 100000;

		writeText("Player Awards\n");
		writeText("Award(s):\t\t\t\t\tPlayer(s):\n");
		System.out.println("-------------------------------------------------------------------------------");

		for (Player player : players) {

			if (player.getLunarCoinBalance() > highestLunarCoin) {
				highestLunarCoin = player.getLunarCoinBalance();
			}

			if (player.getLunarCoinBalance() < lowestLunarCoin) {
				lowestLunarCoin = player.getLunarCoinBalance();
			}

			if (player.getAcceptedFineCount() > acceptedFineCount) {
				acceptedFineCount = player.getAcceptedFineCount();
			}

			if (player.getRefusedFineCount() > refusedFineCount) {
				refusedFineCount = player.getRefusedFineCount();
			}

			if (player.getSquaresTravelled() > mostSquaresTravelled) {
				mostSquaresTravelled = player.getSquaresTravelled();
			}

			if (player.getSquaresTravelled() < fewestSquaresTravelled) {
				fewestSquaresTravelled = player.getSquaresTravelled();
			}

		}

		for (Player player : players) {
			if (highestLunarCoin == player.getLunarCoinBalance()) {
				writeText("Mr / Mrs Moneybags [Most LunarCoin Owned]:\t" + player.getPlayerName() + " ("
						+ player.getLunarCoinBalance() + " LunarCoin)\n");
			}
		}
		for (Player player : players) {
			if (lowestLunarCoin == player.getLunarCoinBalance()) {
				writeText("Peasant            [Least LunarCoin Owned]:\t" + player.getPlayerName() + " ("
						+ player.getLunarCoinBalance() + " LunarCoin)\n");
			}
		}
		for (Player player : players) {
			if (acceptedFineCount == player.getAcceptedFineCount() && acceptedFineCount != 0) {
				writeText("Cheapskate         [Most accepted fines]: \t" + player.getPlayerName() + "("
						+ player.getAcceptedFineCount() + ")\n");
			}
		}
		for (Player player : players) {
			if (refusedFineCount == player.getRefusedFineCount() && refusedFineCount != 0) {
				writeText("Saint              [Most refused fines]: \t" + player.getPlayerName() + "("
						+ player.getRefusedFineCount() + ")\n");
			}
		}
		for (Player player : players) {
			if (mostSquaresTravelled == player.getSquaresTravelled() && mostSquaresTravelled != 0) {
				writeText("Voyager            [Most Travelled]: \t\t" + player.getPlayerName() + "("
						+ player.getSquaresTravelled() + " squares)\n");
			}
		}
		for (Player player : players) {
			if (fewestSquaresTravelled == player.getSquaresTravelled() && fewestSquaresTravelled != 0) {
				writeText("Homebird           [Least Travelled]: \t\t" + player.getPlayerName() + "("
						+ player.getSquaresTravelled() + " squares)\n");
			}
		}
	}

}// end main