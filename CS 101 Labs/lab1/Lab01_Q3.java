import java.lang.Math;

public class Lab01_Q3 {
  
    public static void main(String[] args){
        final double humanBodyMass = 70;
//MP stands for atom Mass Percentage, NP stands for atom Number Percentage in human body.
        final double specifiedElementsMP = 98.6;
        final double oxygenMP = 65;
        final double carbonMP = 18.5;
        final double hydrogenMP = 10;
        final double nitrogenMP = 3.2;
        final double calciumMP = 1.5;

        final double oxygenNP = 24;
        final double hydrogenNP = 62;

        final double numberOfAtomsinHumanBody = humanBodyMass/10 * Math.pow(10,27);
        
        double phosphorusMP = (specifiedElementsMP - (oxygenMP + carbonMP + hydrogenMP + nitrogenMP + calciumMP));
        double otherElementsMP = (100 - specifiedElementsMP);
        double otherElementsAtomCount = (otherElementsMP * numberOfAtomsinHumanBody);
        double oxygenMass = humanBodyMass * oxygenMP/100;
        double carbonMass = humanBodyMass * carbonMP/100;
        double hydrogenCount = numberOfAtomsinHumanBody * hydrogenNP/100;
        double oxygenCount = numberOfAtomsinHumanBody * oxygenNP/100;

        System.out.println( "Phosphorus makes up " + phosphorusMP + " percent of the mass in the human \n body." );
        System.out.println("Elements other than oxygen, carbon, hydrogen, nitrogen, calcium and \n phosphorus make up " 
        + otherElementsMP + " percent of the mass with an atom \n count of " + otherElementsAtomCount + "\n");

        System.out.println("For a person of " + humanBodyMass + " kg the mass of the elements are: \n");
        System.out.println("Oxygen: " + oxygenMass + "kg");
        System.out.println("Carbon: " + carbonMass + "kg \n");

        System.out.println("whereas the number of atoms of some elements in this person are:");

       /*  System.out.printf("Hydrogen: %.2G", hydrogenCount);
        System.out.println();
        System.out.printf("Oxygen: %.2E", oxygenCount);
 */
       System.out.println("Hydrogen: " + hydrogenCount);
        System.out.println("Oxygen: " + oxygenCount);

        
    }

}
