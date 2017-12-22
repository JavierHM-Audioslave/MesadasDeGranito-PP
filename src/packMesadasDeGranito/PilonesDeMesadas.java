package packMesadasDeGranito;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PilonesDeMesadas {
	
	private Mesada mesadas[];
	
	
	public PilonesDeMesadas()
	{
		File archIn;
		Scanner sc;
		try
		{
			archIn=new File(JOptionPane.showInputDialog("Ingrese el patch completo del archivo de entrada"));
			sc=new Scanner(archIn);
			mesadas=new Mesada[sc.nextInt()];
			for(int i=0; i<mesadas.length; i++)
			{
				mesadas[i]=new Mesada(sc.nextDouble(), sc.nextDouble());
			}
			
			try
			{
				sc.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void generarSalida()
	{
		Double difArea1=(double)200001;
		ArrayList<Integer> posiciones1=new ArrayList<Integer>();
		Integer vaApiladoEn1=200001;
		Double difArea2=(double)200001;
		ArrayList<Integer> posiciones2=new ArrayList<Integer>();
		Integer vaApiladoEn2=200001;
		Arrays.sort(this.mesadas,new ComparaLadosYArea()); // Al final, por como hice el ejercicio, usar el sort está demas. Si lo saco el programa funciona igual. //
		// Con lo de arriba, tengo el array de mesadas ordenado. Debajo tengo que crear la logica para analizar qué mesadas se pueden poner arriba de cada pila. //
		ArrayList<Mesada> pilas=new ArrayList<Mesada>();
		pilas.add(mesadas[0]);
		for(int i=1; i<mesadas.length; i++)
		{
			boolean vaApiladoEnAlgunLugar1=false;
			
			for(int j=0; j<pilas.size(); j++)
			{
				if(mesadas[i].getA()<=pilas.get(j).getA() && mesadas[i].getB()<=pilas.get(j).getB())
				{
					vaApiladoEnAlgunLugar1=true;
					posiciones1.add(j);
				}
			}
			
			String[] dev1=null;
			if(vaApiladoEnAlgunLugar1==true)
			{
				dev1=mesadas[i].diferenciaDeAreas(posiciones1,pilas);
				vaApiladoEn1=Integer.parseInt(dev1[0]);
				difArea1=Double.parseDouble(dev1[1]);
				//pilas.set(vaApiladoEn, mesadas[i]);
			}
			
			boolean vaApiladoEnAlgunLugar2=false;
			for(int j=0; j<pilas.size(); j++)
			{
				if(mesadas[i].getA()<=pilas.get(j).getB() && mesadas[i].getB()<=pilas.get(j).getA())
				{
					vaApiladoEnAlgunLugar2=true;
					posiciones2.add(j);
				}
			}
			
			String[] dev2=null;
			if(vaApiladoEnAlgunLugar2==true)
			{
				dev2=mesadas[i].diferenciaDeAreas(posiciones2,pilas);
				vaApiladoEn2=Integer.parseInt(dev2[0]);
				difArea2=Double.parseDouble(dev2[1]);
			}
			
			
			if(vaApiladoEnAlgunLugar1==false && vaApiladoEnAlgunLugar2==false)
			{
				pilas.add(mesadas[i]);
			}			
				
			if(vaApiladoEnAlgunLugar1==true && vaApiladoEnAlgunLugar2==true)
			{
				//Double difArea2=mesadas[i].diferenciaDeAreas(posiciones,pilas);
				if(difArea1<difArea2)
				{
					pilas.set(vaApiladoEn1, mesadas[i]);
				}
				else
				{
					pilas.set(vaApiladoEn2, mesadas[i]);
				}
					
			}


			if(vaApiladoEnAlgunLugar1==true && vaApiladoEnAlgunLugar2==false)
			{
				pilas.set(vaApiladoEn1, mesadas[i]);
			}


			if(vaApiladoEnAlgunLugar1==false && vaApiladoEnAlgunLugar2==true)
			{
				pilas.set(vaApiladoEn2, mesadas[i]);
			}			
			
			posiciones1.clear();
			posiciones2.clear();
		}
		
		
		
		
		File archSal;
		FileWriter fw;
		PrintWriter pw;		
		try
		{
			archSal=new File(JOptionPane.showInputDialog("Ingrese path completo del archivo de salida"));
			fw=new FileWriter(archSal);
			pw=new PrintWriter(fw);
			pw.print(pilas.size());
			try
			{
				fw.close();
				pw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}	
	}
	
	
	
	
	
	
	
	
}
