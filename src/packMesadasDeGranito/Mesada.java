package packMesadasDeGranito;

import java.util.ArrayList;

public class Mesada{
	
	private Double a;
	private Double b;
	
	public Mesada(Double a, Double b)
	{
		this.a=a;
		this.b=b;
	}

	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}
	
	public String[] diferenciaDeAreas(ArrayList<Integer> posiciones,ArrayList<Mesada> pilas)
	{
		Double difDeAreas=(double) 1000000000;
		Integer posDondeMeterloEnLaPila=-1;
		double area1=this.a*this.b;
		
		for(Integer i=0; i<posiciones.size(); i++)
		{
			double area2= pilas.get(posiciones.get(i)).getA()*pilas.get(posiciones.get(i)).getB();
			if(area1<=area2 )
			{
				if((area2-area1)<difDeAreas)
				{
					posDondeMeterloEnLaPila=i;
					difDeAreas=area2-area1;
				}
			}
		}	
		
		String[] dev=new String[2];
		//return posDondeMeterloEnLaPila;
		//if(difDeAreas!=(double)1000000000)
		//{
			dev[0]=String.valueOf(posDondeMeterloEnLaPila);
			dev[1]=String.valueOf(difDeAreas);
		//}
		//else
		//{
			//dev[0]=null;
			//dev[1]=null;
		//}
		
		return dev;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesada other = (Mesada) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}
	
	

}
