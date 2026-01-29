package JogoSudoku.model;


public class Space {

    private final Integer expected; // Pode ser null
    private Integer actual;
    private final boolean fixed;

    public Space(final Integer expected, final boolean fixed) {
        this.expected = expected;
        this.fixed = fixed;

        if (fixed) {
            this.actual = expected;
        }
    }


    public Integer getActual() {
        return actual;
    }

    public Integer getExpected() {
        return expected;
    }

    public boolean isFixed() {
        return fixed;
    }


    public void setActual(final Integer actual) {
        if (fixed) {
            return;
        }
        this.actual = actual;
    }

    public void clearSpace() {
        setActual(null);
    }


    /**
     * Verifica se o valor atual está correto.
     * Espaços sem valor esperado não geram erro.
     */
    public boolean isCorrect() {
        if (expected == null || actual == null) {
            return true;
        }
        return expected.equals(actual);
    }
}
