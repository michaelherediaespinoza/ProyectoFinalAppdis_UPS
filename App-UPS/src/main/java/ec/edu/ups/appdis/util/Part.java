package ec.edu.ups.appdis.util;

public class Part {
	public double PartProb;
    public int PartId;
    
    public Part(int id, double prob) 
	 {
        this.PartId = id;
        this.PartProb = prob;
    }

	public double getPartProb() {
		return PartProb;
	}

	public void setPartProb(double partProb) {
		PartProb = partProb;
	}

	public int getPartId() {
		return PartId;
	}

	public void setPartId(int partId) {
		PartId = partId;
	}
	
    
    
}

