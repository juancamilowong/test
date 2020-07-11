/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectomobiliario.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Usuario
 */
public class Poker {

    private static final int POKER_STRAIGHT_LENGTH = 5;
    private static final int AS = 14;

    public boolean isPokerStraight(int[] cards) {

        if (!validHand(cards)) {
            return false;
        }

        int positionAS = Arrays.stream(cards)
                .boxed()
                .collect(Collectors.toList())
                .indexOf(AS);

        if (positionAS >= 0) {
            
            long possibleStraightLenght1 = Arrays.stream(cards).filter(x -> x < 14 && x <= 5).count();
            
            if(possibleStraightLenght1 >= 4){                
                cards[positionAS] = 1;
                Arrays.sort(cards);
                boolean flag = isStraight(cards);
                cards[positionAS] =14;
                return flag;
            }
            
            long possibleStraightLenght2 = Arrays.stream(cards).filter(x -> x < 14 && x >= 10).count();
            
             
            if(possibleStraightLenght2 >= 4){                
                Arrays.sort(cards);
            }            
            //Valido ultimas posiciones
            if ((positionAS <= 2) && cards[positionAS + 1] == 2) {
                cards[positionAS] = 1;
                boolean flag = isStraight(cards);
                cards[positionAS] =14;
                return flag;

            }
            
        }

        return isStraight(cards);
    }

    public boolean isStraight(int[] cards) {

        boolean flag = false;
        int value = -1;
        int eval = 1;
        for (int i = 0; i < cards.length; i++, value++, eval++) {

            if (cards[i] < value || cards[i] > value + 1 || value < 0) {
                value = cards[i];
                eval = 1;
                continue;
            } else {
                if (cards[i] != value) {
                    eval = 1;
                }
            }

            if (eval >= POKER_STRAIGHT_LENGTH) {
                flag = true;
            }
        }
        return flag;

    }

    public boolean validHand(int[] cards){
        Predicate<Integer> limitValues = x -> x < 2 || x > 14;

        //Valido tamaño de la lista o array
        if (cards == null || cards.length > 7 || cards.length < 5) {
            return false;   
        }

        List<Integer> cardsList = Arrays.stream(cards).boxed().collect(Collectors.toList());

        // Valido que los valores del array se encuentren dentro de los limites
        if (cardsList.stream().anyMatch(limitValues)) {
            return false;
        }
        
        return true;
    }

    
}
