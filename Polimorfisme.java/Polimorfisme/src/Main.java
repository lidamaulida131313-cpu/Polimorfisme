public class Main {

    public static void main(String[] argv) {   
       
        // PERCOBAAN 1: KONSEP DASAR POLIMORFISME
        
        Pegawai p = new Pegawai();
        p = new Programmer(); // Polimorfisme (Superclass menunjuk ke objek Subclass)
        p = new Manajer();    // Polimorfisme (Superclass menunjuk ke objek Subclass)

        // PERCOBAAN 2: VIRTUAL METHOD INVOCATION (VMI)
 
        Manajer m1 = new Manajer();
        m1.gajiPokok = 10000;
        m1.nama = "Sai";
        m1.tunjangan = 5000;

        p = m1; // Polimorfisme: p menunjuk ke instansi Manajer m1
        p.tampilData(); // VIRTUAL METHOD INVOCATION (VMI)
        m1.tampilData(); // Bukan VMI (tipe variabel dan objek sama)

        System.out.println("\n------------------------------------------------\n");

        // PERCOBAAN 3: HETEROGENEOUS COLLECTION
        
        // Array bertipe Superclass yang menampung berbagai tipe objek Subclass
        Pegawai[] arrPeg = new Pegawai[6];

        // Instansiasi objek-objek Programmer
        Programmer pr1 = new Programmer();
        pr1.nama = "uchiha";
        pr1.gajiPokok = 100000;
        pr1.bonus = 120000;

        Programmer pr2 = new Programmer();
        pr2.nama = "Naruto";
        pr2.gajiPokok = 150000;
        pr2.bonus = 180000;

        Programmer pr3 = new Programmer();
        pr3.nama = "Sakura";
        pr3.gajiPokok = 120000;
        pr3.bonus = 100000;

        // Instansiasi objek-objek Manajer
        Manajer m2 = new Manajer();
        m2.nama = "Kakashi";
        m2.gajiPokok = 200000;
        m2.tunjangan = 90000;

        Manajer m3 = new Manajer();
        m3.nama = "Jiraiya";
        m3.gajiPokok = 250000;
        m3.tunjangan = 120000;

        // Pengisian objek ke dalam array heterogen
        arrPeg[0] = p;     // Objek Manajer m1
        arrPeg[1] = m1;    // Objek Manajer m1
        arrPeg[2] = pr1;   // Objek Programmer pr1
        arrPeg[3] = m2;    // Objek Manajer m2
        arrPeg[4] = pr2;   // Objek Programmer pr2
        arrPeg[5] = m3;    // Objek Manajer m3

        // Menampilkan seluruh data objek dari array heterogen
        for (int i = 0; i < arrPeg.length; i++) {
            System.out.println("--- Data Pegawai Indeks ke-" + i + " ---");
            arrPeg[i].tampilData();
            System.out.println();
        }

        System.out.println("------------------------------------------------\n");

        // PERCOBAAN 4: POLYMORPHIC ARGUMENT, INSTANCEOF, & CASTING OBJECT
        
        // Pemanggilan fungsi hitungGajiTotal() dengan argumen polimorfik
        hitungGajiTotal(m1);
        hitungGajiTotal(m2);
        hitungGajiTotal(m3);
        hitungGajiTotal(pr1);
        hitungGajiTotal(pr2);
        hitungGajiTotal(pr3);
    }

    // Method pendukung Percobaan 4 (Polymorphic Argument)
    public static void hitungGajiTotal(Pegawai p) {
        if (p instanceof Programmer) {
            Programmer prog = (Programmer) p; // Casting Object
            int gajiTot = prog.bonus + prog.gajiPokok;
            System.out.println("Gaji Total Programmer (" + prog.nama + ") = " + gajiTot);
        } else if (p instanceof Manajer) {
            Manajer man = (Manajer) p; // Casting Object
            int gajiTot = man.tunjangan + man.gajiPokok;
            System.out.println("Gaji Total Manajer (" + man.nama + ") = " + gajiTot);
        }
    }
}