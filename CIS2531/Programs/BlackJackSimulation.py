import random
# David White
# 10/24/2022
# CIS-2531
# Instructor: Carolyn England
# Assignment: Blackjack Simulation
# Description: Simulate a simplified version of blackjack between two players


def create_deck():
    deck = {'Ace of Spades': 11, '2 of Spades': 2, '3 of Spades': 3,
            '4 of Spades': 4, '5 of Spades': 5, '6 of Spades': 6,
            '7 of Spades': 7, '8 of Spades': 8, '9 of Spades': 9,
            '10 of Spades': 10, 'Jack of Spades': 10,
            'Queen of Spades': 10, 'King of Spades': 10,

            'Ace of Hearts': 11, '2 of Hearts': 2, '3 of Hearts': 3,
            '4 of Hearts': 4, '5 of Hearts': 5, '6 of Hearts': 6,
            '7 of Hearts': 7, '8 of Hearts': 8, '9 of Hearts': 9,
            '10 of Hearts': 10, 'Jack of Hearts': 10,
            'Queen of Hearts': 10, 'King of Hearts': 10,

            'Ace of Clubs': 11, '2 of Clubs': 2, '3 of Clubs': 3,
            '4 of Clubs': 4, '5 of Clubs': 5, '6 of Clubs': 6,
            '7 of Clubs': 7, '8 of Clubs': 8, '9 of Clubs': 9,
            '10 of Clubs': 10, 'Jack of Clubs': 10,
            'Queen of Clubs': 10, 'King of Clubs': 10,

            'Ace of Diamonds': 11, '2 of Diamonds': 2, '3 of Diamonds': 3,
            '4 of Diamonds': 4, '5 of Diamonds': 5, '6 of Diamonds': 6,
            '7 of Diamonds': 7, '8 of Diamonds': 8, '9 of Diamonds': 9,
            '10 of Diamond': 10, 'Jack of Diamonds': 10,
            'Queen of Diamonds': 10, 'King of Diamonds': 10}
    return deck


def deal(hand, deck):
    hand.append(deck.pop(0))


def score(player_hand, card_values):
    player_score = 0
    for idx, val in enumerate(player_hand):
        player_score += card_values[val]
        if (card_values[val] == 11) and (player_score > 21):
            player_score -= 10
    return player_score


def show_info(your_score, dealer_score, your_hand, dealer_hand):
    print("Deal\t", "Player 1\t\t")
    print("----\t", "--------\t\t")
    for idx, val in enumerate(your_hand):
        print(f'{idx + 1:<8}', f'{val}')
    print()
    print("Deal\t", "Player 2\t\t")
    print("----\t", "--------\t\t")
    for idx, val in enumerate(dealer_hand):
        print(f'{idx + 1:<8}', f'{val}')
    print("===========================================")
    print(f'{"Score:":<10}', f'Player 1: {your_score:<5}', f'Player 2: {dealer_score}\t')
    if (your_score > 21) and (dealer_score > 21):
        print("No Winner")
    elif (your_score == dealer_score) and (your_score >= 21):
        print("Both Players Win")
    elif (your_score > dealer_score) and (your_score <= 21):
        print("Player 1 wins!")
    elif (your_score > dealer_score) and (your_score > 21):
        print("Player 2 Wins!")
    elif (dealer_score > your_score) and (dealer_score > 21):
        print("Player 1 Wins!")
    elif (dealer_score > your_score) and (dealer_score <= 21):
        print("Player 2 Wins!")
    print()


def single_round(card_values, deck):
    your_score = 0
    dealer_score = 0

    your_hand = []
    dealer_hand = []
    while (your_score <= 17) or (dealer_score <= 17):
        deal(your_hand, deck)
        deal(dealer_hand, deck)
        your_score = score(your_hand, card_values)
        dealer_score = score(dealer_hand, card_values)

    show_info(your_score, dealer_score, your_hand, dealer_hand)


def full_game(card_values, deck):
    rounds = 0
    cards_played = 0
    player_wins = 0
    house_wins = 0
    both_wins = 0
    no_wins = 0

    while len(deck) >= 2:
        print("***NEW ROUND***")
        rounds += 1
        your_score = 0
        dealer_score = 0

        your_hand = []
        dealer_hand = []
        while ((your_score <= 17) or (dealer_score <= 17)) and (len(deck) >= 2):
            deal(your_hand, deck)
            deal(dealer_hand, deck)
            your_score = score(your_hand, card_values)
            dealer_score = score(dealer_hand, card_values)
            cards_played += 2

        show_info(your_score, dealer_score, your_hand, dealer_hand)
        if (your_score > 21) and (dealer_score > 21):
            no_wins += 1
        elif (your_score == dealer_score) and (your_score <= 21):
            both_wins += 1
        elif (your_score > dealer_score) and (your_score <= 21):
            player_wins += 1
        elif (your_score > dealer_score) and (your_score > 21):
            house_wins += 1
        elif (dealer_score > your_score) and (dealer_score > 21):
            player_wins += 1
        elif (dealer_score > your_score) and (dealer_score <= 21):
            house_wins += 1
    print("***GAME STATISTICS***")
    print("Rounds Played:", f'{rounds:4}')
    print("Cards Played:", f'{cards_played:5}')
    print("Player 1 Wins:", f'{player_wins:4}')
    print("Player 2 Wins:", f'{house_wins:4}')
    print("Both Wins:", f'{both_wins:8}')
    print("No Wins:", f'{no_wins:10}')


def get_card_values(card, card_values):
    return card_values[card]


def main():
    # Create a deck of cards
    card_values = create_deck()
    deck = list(card_values.keys())

    # shuffle deck
    random.shuffle(deck)

    print("Welcome to the BlackJack Simulator")
    print("1. Play a Single Round")
    print("2. Play a Full Deck")
    print("-1 to quit")
    choice = int(input())
    if choice == 1:
        single_round(card_values, deck)
    if choice == 2:
        full_game(card_values, deck)


if __name__ == "__main__":
    main()
