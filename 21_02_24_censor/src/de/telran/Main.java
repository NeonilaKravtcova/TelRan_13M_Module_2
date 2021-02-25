package de.telran;

public class Main {
    public static void main(String[] args) {


        String text0 = "I love this badWord1 Java however some of these badWord2 exercises are really badWord3";
        String text1 = "I love Java however some of these difficult exercises are really interesting";
        String text2 = "I love this Java however some of these bad exercises are really interesting";

        Censor censor = new Censor();

        System.out.println(censor.verify(text0));
        System.out.println(censor.verify(text1));
        System.out.println(censor.verify(text2));
        System.out.println(censor.verify("text1"));
        System.out.println(censor.verify("badWord"));
        System.out.println(censor.verify("1badWord5"));
        System.out.println(censor.verify("badWord2"));
        System.out.println(censor.verify("badWord3"));
        System.out.println(censor.verify("I try to realise this badWord1 method"));

    }
}
