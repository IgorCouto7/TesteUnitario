import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class CampeaoTest {


    
    @Test
    void testeCriarAssassino() {
        Campeao zed = new Assassino("Zed", "Mid", 5);
        assertEquals("Zed", zed.nome);
        assertEquals("Mid", zed.rota);
        assertEquals(5, zed.nivel);
    }

    @Test
    void testeCriarMago() {
        Campeao lux = new Mago("Lux", "Mid", 3);
        assertEquals("Lux", lux.nome);
        assertEquals("Mid", lux.rota);
        assertEquals(3, lux.nivel);
    }

    @Test
    void testeCriarAtirador() {
        Campeao jinx = new Atirador("Jinx", "Bot", 1);
        assertEquals("Jinx", jinx.nome);
        assertEquals("Bot", jinx.rota);
        assertEquals(1, jinx.nivel);
    }

    @Test
    void testeUparCampeao() {
        Campeao lux = new Mago("Lux", "Mid", 2);
        lux.upar();
        assertEquals(3, lux.nivel);
    }

    @Test
    void testeAtaqueAssassino() {
        Campeao zed = new Assassino("Zed", "Mid", 5);
        assertDoesNotThrow(() -> zed.atacar());
    }

    @Test
    void testeAtaqueMago() {
        Campeao lux = new Mago("Lux", "Mid", 3);
        assertDoesNotThrow(() -> lux.atacar());
    }

    @Test
    void testeAtaqueAtirador() {
        Campeao jinx = new Atirador("Jinx", "Bot", 1);
        assertDoesNotThrow(() -> jinx.atacar());
    }

    @Test
    void testeCampeaoMaisAlto() {
        ArrayList<Campeao> campeoes = new ArrayList<>();
        campeoes.add(new Assassino("Zed", "Mid", 3));
        campeoes.add(new Mago("Lux", "Mid", 5));
        campeoes.add(new Atirador("Jinx", "Bot", 4));

        Campeao maisAlto = campeoes.get(0);
        for (Campeao c : campeoes) {
            if (c.nivel > maisAlto.nivel) {
                maisAlto = c;
            }
        }

        assertEquals("Lux", maisAlto.nome);
        assertEquals(5, maisAlto.nivel);
    }

    @Test
    void testeUparVariosVezes() {
        Campeao zed = new Assassino("Zed", "Mid", 1);
        for (int i = 0; i < 5; i++) zed.upar();
        assertEquals(6, zed.nivel);
    }

    // ==================== TESTES NEGATIVOS ====================

    @Test
    void testeCriarCampeaoNomeNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Assassino(null, "Mid", 1);
        });
    }

    @Test
    void testeCriarCampeaoRotaNula() {
        assertThrows(NullPointerException.class, () -> {
            new Mago("Lux", null, 1);
        });
    }

    @Test
    void testeNivelNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Atirador("Jinx", "Bot", -1);
        });
    }

    @Test
    void testeUparCampeaoNegativo() {
        Campeao zed = new Assassino("Zed", "Mid", 5);
        // Simula falha: upar decrementando (não permitido)
        assertThrows(IllegalArgumentException.class, () -> {
            zed.nivel = -1; // acesso direto, "negativo"
        });
    }

    @Test
    void testeAtaqueCampeaoNulo() {
        Campeao c = null;
        assertThrows(NullPointerException.class, () -> c.atacar());
    }

    @Test
    void testeCampeaoMaisAltoListaVazia() {
        ArrayList<Campeao> campeoes = new ArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Campeao maisAlto = campeoes.get(0);
        });
    }

    @Test
    void testeRemoverCampeaoInexistente() {
        ArrayList<Campeao> campeoes = new ArrayList<>();
        campeoes.add(new Assassino("Zed", "Mid", 1));
        assertThrows(IndexOutOfBoundsException.class, () -> campeoes.remove(5));
    }

    @Test
    void testeAdicionarCampeaoNulo() {
        ArrayList<Campeao> campeoes = new ArrayList<>();
        campeoes.add(null);
        assertNull(campeoes.get(0));
    }

    @Test
    void testeCriarCampeaoNivelZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Mago("Lux", "Mid", 0);
        });
    }

    @Test
    void testeAlterarNivelParaZero() {
        Campeao zed = new Assassino("Zed", "Mid", 1);
        assertThrows(IllegalArgumentException.class, () -> {
            zed.nivel = 0; // acesso direto, simula falha
        });
    }
}
