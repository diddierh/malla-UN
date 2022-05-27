package mc;

import java.util.Comparator;

public class MateriaComparator implements Comparator<Materia>{
	public int compare(Materia m1, Materia m2) {
		if(m1.getDepth() == m2.getDepth()) {
			if(m1.getSemester() == m2.getSemester()) {
				if(m1.getDependants().size() == m1.getDependants().size()) {
					return m2.getCreditos() - m1.getCreditos();
				}
				else {
					return m2.getDependants().size()- m1.getDependants().size();
				}
			}
			else {
				return m1.getSemester() - m2.getSemester();
			}
		}
		else {
			return m2.getDepth() - m1.getDepth();
		}
		
		
//		if(m1.getDepth() == m2.getDepth()) {
//			if(m1.getDependants().size() == m1.getDependants().size()) {
//				if(m1.getSemester() == m2.getSemester()) {
//					return m2.getCreditos() - m1.getCreditos();
//				}
//				else {
//					return m2.getDependants().size()- m1.getDependants().size();
//				}
//			}
//			else {
//				return m1.getSemester() - m2.getSemester();			
//			}
//		}
//		else {
//			return m2.getDepth() - m1.getDepth();
//		}
	}
}
