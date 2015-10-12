package designPatterns.chainOfResponsibility.sample.atm;

public class Main {
    
    public static void main(String[] args) {
        // конструктор по-умочанию для номиналов 1, 5, 10, 20, 50 и 100
        Atm atm = new Atm();
        atm.withdraw(186);
        // 186 =
        // 1 x $100
        // 1 x $10
        // 1 x $5
        // 1 x $1
        // --------

        atm.withdraw(72);
        // 72 =
        // 1 x $50
        // 1 x $20
        // 2 x $1
        // --------

        atm.withdraw(1564);
        // 1564 =
        // 15 x $100
        // 1 x $50
        // 1 x $10
        // 4 x $1
        // --------

        // а представь как было бы, если каждый номинал купюры
        // был бы простым числом? :)
        Atm atm2 = new Atm(1, 2, 3, 5, 7, 11, 13, 17, 19, 23,
                29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
                127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
                179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
                233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
                283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
                353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
                419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
                467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
                547, 557, 563, 569, 571, 577, 587, 593, 599, 601,
                607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
                661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
                739, 743, 751, 757, 761, 769, 773, 787, 797, 809,
                811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
                877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
                947, 953, 967, 971, 977, 983, 991, 997);

        atm2.withdraw(2342332);
        // 2342332 =
        // 2349 x $997
        // 1 x $379
        // --------

        atm2.withdraw(3453245);
        // 3453245 =
        // 3463 x $997
        // 1 x $631
        // 1 x $3
        // --------

        atm2.withdraw(123245);
        // 123245 =
        // 123 x $997
        // 1 x $613
        // 1 x $1
        // --------

        atm2.withdraw(23423);
        // 23423 =
        // 23 x $997
        // 1 x $491
        // 1 x $1
        // --------

        atm2.withdraw(34621437);
        // 34621437 =
        // 34725 x $997
        // 1 x $607
        // 1 x $5
        // --------

        // интересно :)
    }
}