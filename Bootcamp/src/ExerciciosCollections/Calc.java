package ExerciciosCollections;

//public interface Calc {
//    Object exec(long[] numberArray);

    @FunctionalInterface
    public interface Calc{

        long exec(long... numbers);
    }

