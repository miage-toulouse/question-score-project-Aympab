package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple uneQuestion;

    @Before
    public void setUp() throws Exception {
        //given : cas de départ, une question à choix multiple
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        uneQuestion = new QuestionAChoixMultiple("un enoncé", list);
    }

    @Test
    public void testGetEnonce() {
        //when :
        String resEnonce = this.uneQuestion.getEnonce();

        //then
        assertNotNull(resEnonce);
        assertEquals(resEnonce,"un énoncé");
    }

    @Test
    public void testGetScoreForIndice() {
        // when : un étudiant fourni un indice d'une bonne réponse
        int indiceEtudiant = 2;
        // and: on demande le calcule du score
        Float resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est de la moitié donc 50
        assertEquals(new Float(50f),resScore);

        // when : un étudiant fourni un indice d'une bonne réponse
        indiceEtudiant = 1;
        // and: on demande le calcule du score
        resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est de la moitié donc 50
        assertEquals(new Float(50f),resScore);

        // when : un étudiant fourni l'indice correspondant à une mauvais réponse
        indiceEtudiant = 3;
        // and: on demande le calcule du score
        resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 0
        assertEquals(new Float(0f),resScore);

    }
}