package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private QuestionAChoixMultiple questionAChoixMultiple;
    private ScoreCalculateur sc;
    private float res;

    @Before
    public void setUp() throws Exception {
        //given : une question a choix multiple telle que :
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));

        //et un score calculateur
        sc = new ScoreCalculateur();
    }

    @Test
    public void testCalculeScore() {
        //quand on calcule le score pour une liste de réponses contenant les valeurs 1 et 4, on obtient 0 comme résultat ;
        //when la liste de réponses est :
        ArrayList<Integer> listeRep = new ArrayList<Integer>(Arrays.asList(1,4));
        //et qu'on test le score
        res = sc.calculeScore(listeRep, questionAChoixMultiple);

        //On doit obtenir 0
        assertEquals(res,0);


        //quand on calcule le score pour une liste de réponses contenant les valeurs 2 et 3, on obtient 2*100/3 à 0,01 près comme résultat ;
        //when la liste de réponses est :
        listeRep = new ArrayList<Integer>(Arrays.asList(2,3));
        //et qu'on test le score
        res = sc.calculeScore(listeRep, questionAChoixMultiple);

        //On doit obtenir 0
        assertEquals(res,2*100/3, 0.01f);

        //quand on calcule le score pour une liste de réponses contenant les valeurs 2, 3 et 5, on obtient 100 à 0,01 près comme résultat.
        //when la liste de réponses est :
        listeRep = new ArrayList<Integer>(Arrays.asList(2,3,5));
        //et qu'on test le score
        res = sc.calculeScore(listeRep, questionAChoixMultiple);

        //On doit obtenir 0
        assertEquals(res,100, 0.01f);
    }
}