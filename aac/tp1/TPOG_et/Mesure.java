import java.io.*;
import java.lang.String;
import java.util.*;
import java.lang.Class;
import java.lang.System;
import java.lang.Math;

public class Mesure {

	/**
	 * tSize[] contient, par ordre croissant, toutes les tailles de donnees pour
	 * lesquelles les temps d'execution des algorithmes seront mesures par l'une
	 * des methodes mesureNomAlgorithme sur l'objet de type Mesure.
	 */
	int tSize[];
	/**
	 * tRep[i] contient le nombre de donnees differentes toutes de taille
	 * tSize[i] sur lequel la moyenne des temps d'executions sera calculee par
	 * l'une des methodes mesureNomAlgorithme sur l'objet de type Mesure.
	 */
	int tRep[];
	/**
	 * tRes[i] contient a l'issue d'une mesure effectuee par une methode
	 * mesureNomAlgorithme le temps moyen d'execution de l'algorithme
	 * NomAlgorithme sur tRep[i] donnees differentes de taille tSize[i] .
	 */
	double tRes[];

	/**************************************************************************
	 ************************************************************************** 
	 **************************** CONSTRUCTEUR ********************************
	 ************************************************************************** 
	 *************************************************************************/

	public Mesure(int[] tSize, int[] tRep) {
		this.tSize = tSize;
		this.tRep = tRep;
		this.tRes = new double[tSize.length];

		for (int i = 0; i < this.tRes.length; i++) {
			this.tRes[i] = 0;
		}

	}

	/**************************************************************************
	 ************************************************************************** 
	 ************************ MESURE DES ALGORITHMES **************************
	 ************************************************************************** 
	 *************************************************************************/

	/**
	 * ecrit dans tRes[] les moyennes de temps de calcul de rechercheL sur les
	 * nombres contenus dans tRep[] d'executions sur des donnees dont les
	 * tailles sont indiquees dans tSize[], pour la recherche de l'element 0 qui
	 * est contenu dans L
	 */

	public void mesureRechercheL() {
		double startTime;
		double totalTime;
		boolean present;

		this.resetRes();

		for (int i = 0; i < this.tSize.length; i++) {

			Methodes M = new Methodes(this.tSize[i]);

			for (int j = 0; j < this.tRep[i]; j++) {

				M.aleaL();
				/** nouvelle instance */

				startTime = System.nanoTime();
				present = M.rechercheL(0);
				totalTime = (System.nanoTime() - startTime);
				this.tRes[i] = this.tRes[i] + totalTime;
			}
			this.tRes[i] = this.tRes[i] / this.tRep[i];

		}
	}

	/**
	 * ecrit dans tRes[] les moyennes de temps de calcul de rechercheT sur les
	 * nombres contenus dans tRep[] d'executions sur des donnees dont les
	 * tailles sont indiquees dans tSize[], pour la recherche de l'element 0 qui
	 * est contenu dans T
	 */

	public void mesureRechercheT() {
		double startTime;
		double totalTime;
		boolean present;

		this.resetRes();

		for (int i = 0; i < this.tSize.length; i++) {

			Methodes M = new Methodes(this.tSize[i]);

			for (int j = 0; j < this.tRep[i]; j++) {

				M.aleaT();
				/** nouvelle instance */

				startTime = System.nanoTime();
				present = M.rechercheT(0);
				totalTime = (System.nanoTime() - startTime);
				this.tRes[i] = this.tRes[i] + totalTime;
			}
			this.tRes[i] = this.tRes[i] / this.tRep[i];

		}
	}

	/**
	 * ecrit dans tRes[] les moyennes de temps de calcul de minimumSimpleL sur
	 * les nombres contenus dans tRep[] d'executions sur des donnees dont les
	 * tailles sont indiquees dans tSize[]
	 */

	public void mesureMinimumSimpleL() {
		double startTime;
		double totalTime;
		int min;

		this.resetRes();

		for (int i = 0; i < this.tSize.length; i++) {

			Methodes M = new Methodes(this.tSize[i]);

			for (int j = 0; j < this.tRep[i]; j++) {

				M.aleaL();
				/** nouvelle instance */

				startTime = System.nanoTime();
				min = M.minimumSimpleL();
				totalTime = (System.nanoTime() - startTime);
				this.tRes[i] = this.tRes[i] + totalTime;
			}
			this.tRes[i] = this.tRes[i] / this.tRep[i];

		}
	}

	/**
	 * ecrit dans tRes[] les moyennes de temps de calcul de minimumSimpleT sur
	 * les nombres contenus dans tRep[] d'executions sur des donnees dont les
	 * tailles sont indiquees dans tSize[]
	 */

	public void mesureMinimumSimpleT() {
		double startTime;
		double totalTime;
		int min;

		this.resetRes();

		for (int i = 0; i < this.tSize.length; i++) {

			Methodes M = new Methodes(this.tSize[i]);

			for (int j = 0; j < this.tRep[i]; j++) {

				M.aleaT();
				/** nouvelle instance */

				startTime = System.nanoTime();
				min = M.minimumSimpleT();
				totalTime = (System.nanoTime() - startTime);
				this.tRes[i] = this.tRes[i] + totalTime;
			}
			this.tRes[i] = this.tRes[i] / this.tRep[i];

		}
	}

	/**
	 * ecrit dans tRes[] les moyennes de temps de calcul de minimumTriL sur les
	 * nombres contenus dans tRep[] d'executions sur des donnees dont les
	 * tailles sont indiquees dans tSize[]
	 */

	public void mesureMinimumTriL() {
		double startTime;
		double totalTime;
		int min;

		this.resetRes();

		for (int i = 0; i < this.tSize.length; i++) {

			Methodes M = new Methodes(this.tSize[i]);

			for (int j = 0; j < this.tRep[i]; j++) {

				M.aleaL();
				/** nouvelle instance */

				startTime = System.nanoTime();
				min = M.minimumTriL();
				totalTime = (System.nanoTime() - startTime);
				this.tRes[i] = this.tRes[i] + totalTime;
			}
			this.tRes[i] = this.tRes[i] / this.tRep[i];

		}
	}

	/**
	 * ecrit dans tRes[] les moyennes de temps de calcul de minimumTriT sur les
	 * nombres contenus dans tRep[] d'executions sur des donnees dont les
	 * tailles sont indiquees dans tSize[]
	 */

	public void mesureMinimumTriT() {
		double startTime;
		double totalTime;
		int min;

		this.resetRes();

		for (int i = 0; i < this.tSize.length; i++) {

			Methodes M = new Methodes(this.tSize[i]);

			for (int j = 0; j < this.tRep[i]; j++) {

				M.aleaT();
				/** nouvelle instance */

				startTime = System.nanoTime();
				min = M.minimumTriT();
				totalTime = (System.nanoTime() - startTime);
				this.tRes[i] = this.tRes[i] + totalTime;
			}
			this.tRes[i] = this.tRes[i] / this.tRep[i];

		}
	}

	/**
	 * ecrit dans tRes[] les moyennes de temps de calcul de mystereL sur les
	 * nombres contenus dans tRep[] d'executions sur des donnees dont les
	 * tailles sont indiquees dans tSize[]
	 */

	public void mesureMystereL() {
		double startTime;
		double totalTime;

		this.resetRes();

		for (int i = 0; i < this.tSize.length; i++) {

			Methodes M = new Methodes(this.tSize[i]);

			for (int j = 0; j < this.tRep[i]; j++) {

				M.aleaL();
				/** nouvelle instance */

				startTime = System.nanoTime();
				M.mystereL();
				totalTime = (System.nanoTime() - startTime);
				this.tRes[i] = this.tRes[i] + totalTime;
			}
			this.tRes[i] = this.tRes[i] / this.tRep[i];

		}
	}

	/**
	 * ecrit dans tRes[] les moyennes de temps de calcul de mystereT sur les
	 * nombres contenus dans tRep[] d'executions sur des donnees dont les
	 * tailles sont indiquees dans tSize[]
	 */

	public void mesureMystereT() {
		double startTime;
		double totalTime;

		this.resetRes();

		for (int i = 0; i < this.tSize.length; i++) {

			Methodes M = new Methodes(this.tSize[i]);

			for (int j = 0; j < this.tRep[i]; j++) {

				M.aleaT();
				/** nouvelle instance */

				startTime = System.nanoTime();
				M.mystereT();
				totalTime = (System.nanoTime() - startTime);
				this.tRes[i] = this.tRes[i] + totalTime;
			}
			this.tRes[i] = this.tRes[i] / this.tRep[i];

		}
	}

	/**
	 * ecrit dans tRes[] les moyennes de temps de calcul de aleaL sur les
	 * nombres contenus dans tRep[] d'executions sur des donnees dont les
	 * tailles sont indiquees dans tSize[]
	 */

	public void mesureAleaL() {
		double startTime;
		double totalTime;

		this.resetRes();

		for (int i = 0; i < this.tSize.length; i++) {

			Methodes M = new Methodes(this.tSize[i]);

			for (int j = 0; j < this.tRep[i]; j++) {
				startTime = System.nanoTime();
				M.aleaL();
				totalTime = (System.nanoTime() - startTime);
				this.tRes[i] = this.tRes[i] + totalTime;
			}
			this.tRes[i] = this.tRes[i] / this.tRep[i];
		}
	}

	/**
	 * ecrit dans tRes[] les moyennes de temps de calcul de aleaT sur les
	 * nombres contenus dans tRep[] d'executions sur des donnees dont les
	 * tailles sont indiquees dans tSize[]
	 */

	public void mesureAleaT() {
		double startTime;
		double totalTime;

		this.resetRes();

		for (int i = 0; i < this.tSize.length; i++) {

			Methodes M = new Methodes(this.tSize[i]);

			for (int j = 0; j < this.tRep[i]; j++) {
				startTime = System.nanoTime();
				M.aleaT();
				totalTime = (System.nanoTime() - startTime);
				this.tRes[i] = this.tRes[i] + totalTime;
			}
			this.tRes[i] = this.tRes[i] / this.tRep[i];
		}
	}

	/**************************************************************************
	 ************************************************************************** 
	 *********************** FONCTIONS DE REFERENCE ***************************
	 ************************************************************************** 
	 *************************************************************************/

	/**
	 * ecrit dans tRes[] les valeurs de la fonction de reference log n pour les
	 * valeurs de n contenues dans tSize[]
	 */
	public void refLog(double k) {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.log(Math.pow(this.tSize[i], k));
		}
	}

	/**
	 * ecrit dans tRes[] les valeurs de la fonction de reference n^k pour les
	 * valeurs de n contenues dans tSize[]
	 */
	public void refNpK(double k) {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.pow(this.tSize[i], k);
		}
	}

	/**
	 * ecrit dans tRes[] les valeurs de la fonction de reference n log n pour
	 * les valeurs de n contenues dans tSize[]
	 */
	public void refNlogn() {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.log(this.tSize[i]) * ((double) this.tSize[i]);
		}
	}

	/**
	 * ecrit dans tRes[] les valeurs de la fonction de reference exp pour les
	 * valeurs de n contenues dans tSize[]
	 */
	public void refExp() {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.exp(this.tSize[i]);
		}
	}

	/**
	 * ecrit dans tRes[] les valeurs de la fonction de reference k^n pour les
	 * valeurs de n contenues dans tSize[]
	 */
	public void refKpN(double k) {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.pow(k, this.tSize[i]);
		}
	}

	/**************************************************************************
	 ************************************************************************** 
	 ****************** RAPPORTS ENTRE FONCTIONS DE REFERENCE *****************
	 ************************************************************************** 
	 *************************************************************************/

	/**
	 * ecrit dans tRes[] les valeurs du rapport log(n)/log(n^k) pour les valeurs
	 * de n contenues dans tSize[]
	 */
	public void rapportLogLogK(double k) {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.log(this.tSize[i])
					/ Math.log(Math.pow(this.tSize[i], k));
		}
	}

	/**
	 * ecrit dans tRes[] les valeurs du rapport log(n^k)/log(n) pour les valeurs
	 * de n contenues dans tSize[]
	 */
	public void rapportLogKLog(double k) {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.log(Math.pow(this.tSize[i], k))
					/ Math.log(this.tSize[i]);
		}
	}

	/**
	 * ecrit dans tRes[] les valeurs du rapport (n^epsi)/log(n) pour les valeurs
	 * de n contenues dans tSize[]
	 */
	public void rapportNepsiLog(double epsi) {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.pow(this.tSize[i], epsi)
					/ Math.log(this.tSize[i]);
		}
	}

	/**
	 * ecrit dans tRes[] les valeurs du rapport log(n)/(n^epsi) pour les valeurs
	 * de n contenues dans tSize[]
	 */
	public void rapportLogNepsi(double epsi) {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.log(this.tSize[i])
					/ Math.pow(this.tSize[i], epsi);
		}
	}

	/**
	 * ecrit dans tRes[] les valeurs du rapport (2^n)/(n^k) pour les valeurs de
	 * n contenues dans tSize[]
	 */
	public void rapport2pNNpK(double k) {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.pow(2, this.tSize[i])
					/ Math.pow(this.tSize[i], k);
		}
	}

	/**
	 * ecrit dans tRes[] les valeurs du rapport (n^k)/(2^n) pour les valeurs de
	 * n contenues dans tSize[]
	 */
	public void rapportNpK2pN(double k) {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.pow(this.tSize[i], k)
					/ Math.pow(2, this.tSize[i]);
		}
	}

	/**
	 * ecrit dans tRes[] les valeurs du rapport (k^n)/(2^n) pour les valeurs de
	 * n contenues dans tSize[]
	 */
	public void rapportKpN2pN(double k) {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.pow(k, this.tSize[i])
					/ Math.pow(2, this.tSize[i]);
		}
	}

	/**
	 * ecrit dans tRes[] les valeurs du rapport (2^n)/(k^n) pour les valeurs de
	 * n contenues dans tSize[]
	 */
	public void rapport2pNKpN(double k) {
		for (int i = 0; i < this.tSize.length; i++) {
			this.tRes[i] = Math.pow(2, this.tSize[i])
					/ Math.pow(k, this.tSize[i]);
		}
	}

	/**************************************************************************
	 ************************************************************************** 
	 ************************* RESULTATS DES MESURES **************************
	 ************************************************************************** 
	 *************************************************************************/

	/** remise à 0 du tableau tRes[] */
	public void resetRes() {
		for (int i = 0; i < this.tRes.length; i++) {
			this.tRes[i] = 0;
		}
	}

	/**
	 * retourne une copie du tableau tRes[], pour recuperer les resultats entre
	 * deux appels a des methodes mesureNomAlgorithme ou
	 * refNomFonctionDeReference ou encore rapportNomsFonctions
	 */
	public double[] getRes() {

		double copie[] = new double[this.tRes.length];
		for (int i = 0; i < this.tRes.length; i++) {
			copie[i] = this.tRes[i];
		}
		return copie;
	}

	/**
	 * retourne une copie du tableau tRes[] dont chaque element a ete multiplie
	 * par le facteur factor
	 */
	public double[] scaledRes(double factor) {
		double[] tmp = new double[this.tRes.length];

		for (int i = 0; i < this.tRes.length; i++) {
			tmp[i] = factor * this.tRes[i];
		}
		return tmp;
	}

	/**
	 * affiche les valeurs contenues dans le tableau a deux dimension res en
	 * faisant preceder chaque ligne de la taille de donnee contenue dans
	 * tSize[]. Les tableaux res[j] pour j verifiant 0 <= j < res.length sont
	 * ainsi affiches en colonnes successives apres la colonne tSize[].
	 */
	public void output(double[][] res) {

		for (int i = 0; i < res[0].length; i++) {
			System.out.print("" + this.tSize[i]);
			for (int j = 0; j < res.length; j++) {
				System.out.print(" " + res[j][i]);
			}
			System.out.print("\n");
		}

	}

	/**************************************************************************
	 ************************************************************************** 
	 ********************************* MAIN ***********************************
	 ************************************************************************** 
	 *************************************************************************/

	public static void main(String[] arg) throws Exception {

		if (arg.length < 1) {
			System.out.println("toto !");
		} else {

			int size0[] = { 2, 10, 20, 30, 40, 50, 100, 150, 200, 300, 400,
					500, 1000, 1500, 2000, 5000, 10000, 25000, 50000, 75000,
					100000, 250000, 500000 };
			int rep0[] = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
					100, 100, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			double scale0[] = { 200, 300, 400, 500, 600 };

			int choix = Integer.parseInt(arg[0]);

			switch (choix) {
			case 0:
				/** Exemple */
				int nbCourbe0 = scale0.length + 1;
				double[][] res0 = new double[nbCourbe0][size0.length];
				Mesure M0 = new Mesure(size0, rep0);

				M0.mesureAleaT();
				res0[0] = M0.getRes();

				M0.refNpK(1);
				for (int i = 1; i < nbCourbe0; i++) {
					res0[i] = M0.scaledRes(scale0[i - 1]);
				}

				M0.output(res0);

				break;
				case 1:
				int nbCourbe0 = 4;
				double[][] res1 = new double[nbCourbe1][size0.length];
				int rep1[] ={ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
						1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
				Mesure M1 = new Mesure(size0, rep0);
				Mesure M2 = new Mesure(size0, rep1);
				
				M1.mesureAleaT();
				res1[0] = M1.getRes();
				M1.mesureAleaL();
				res1[0] = M1.getRes();
				
				M2.mesureAleaT();
				res1[0] = M2.getRes();
				M2.mesureAleaL();
				res1[0] = M2.getRes();

				M0.refNpK(1);
				for (int i = 1; i < nbCourbe0; i++) {
					res0[i] = M0.scaledRes(scale0[i - 1]);
				}

				M0.output(res0);

				break;

			default:
				break;

			}
		}
	}
}
