package packMesadasDeGranito;

import java.util.Comparator;

public class ComparaLadosYArea implements Comparator<Mesada>{

	@Override
	public int compare(Mesada m1, Mesada m2)
	{
		if(m1.getA()>m2.getA() && m1.getB()>m2.getB())
		{
			return -1;
		}
		
		if(m1.getA()*m1.getB() > m2.getA()*m2.getB())
		{
			return -1;
		}
		else
		{
			if(m1.getA()*m1.getB() < m2.getA()*m2.getB())
			{
				return 1;
			}
		}		
		
		return 0;
	}

}
