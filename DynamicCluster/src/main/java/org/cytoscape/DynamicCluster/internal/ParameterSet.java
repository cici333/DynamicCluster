package org.cytoscape.DynamicCluster.internal;

 

public class ParameterSet
{
  
	//scope
	public static String NETWORK = "network";
	public static String SELECTION = "selection";
	private String scope;
	private Long[] selectedNodes;
	
	private boolean optimize;
  
  
	//used in clustering using TSN-PCD
	private double FThresholdTSNPCD; 
	private int ComplexSizeThresholdTSNPCD;
	private double GExpThresholdTSNPCD;
	 
	//used in clustering using DFM-CIN
	private double SThresholdDFMCIN; 
	private int SMinDFMCIN; 
	private int SMaxDFMCIN;

	public static String TSNPCD = "TSN-PCD";
	public static String DFMCIN = "DFM-CIN";
	
	private String algorithm;
  
  public ParameterSet()
  {
    setDefaultParams();

  }

  
  

  public ParameterSet(
		  String scope, Long[] selectedNodes, boolean optimize,
		  
		  double FThresholdTSNPCD, int ComplexSizeThresholdTSNPCD,double GExpThresholdTSNPCD,
		  
		  double SThresholdDFMCIN, int SMinDFMCIN, int SMaxDFMCIN,	 
		  
		  String algorithm)
  {
	  setAllAlgorithmParams(
			  scope, selectedNodes, optimize,
			  FThresholdTSNPCD, ComplexSizeThresholdTSNPCD, GExpThresholdTSNPCD,
			  SThresholdDFMCIN, SMinDFMCIN, SMaxDFMCIN,	 
			  algorithm
			  );
      
  }
  
  /**
   * Setting all parameters to their default values
  */
  public void setDefaultParams()
  {
    setAllAlgorithmParams(
    		NETWORK,  new Long[0], true,
    		1.0, 3, 0.7,
    		0.4, 3, 50,
    		"");
  }
  

  /**
   * Setting all the main algorithm parameters
   * 
   * @param scope Scope of the search (equal to one of the two fields NETWORK or SELECTION) 
   * @param selectedNodes Node selection for selection-based scope
   * @param optimize Determines if parameters are customized by user/default or optimized
   * 
   * @param a paramater for TSN-PCD method, will affect the clustering results. In general, a real number between 1.0 and 2.0 is suggested
   * @param The clusters whose sizes are smaller than "ComplexSizeThresholdTSNPCD" will not be writen out
   * @param the threshold of the gene expression.given as a number, the default value is 0.7
 
   * @param the similarity between two complexes. In general, a real number between 0 and 1.0 is suggested
   * @param the size of the  output shoud be larger than SMinDFMCIN
   * @param the size of the  output shoud be smaller than SMaxDFMCIN
   */

  public void setAllAlgorithmParams(
		  String scope, Long[] selectedNodes, boolean optimize,
		  
		  double FThresholdTSNPCD, int ComplexSizeThresholdTSNPCD, double GExpThresholdTSNPCD,
		  
		  double SThresholdDFMCIN, int SMinDFMCIN, int SMaxDFMCIN,	 
		  
		  String algorithm)
  {
    this.scope = scope;
    this.selectedNodes = selectedNodes;
    this.optimize = optimize;
 
    //used in clustering using TSN-PCD
    this.FThresholdTSNPCD = FThresholdTSNPCD;
    this.ComplexSizeThresholdTSNPCD = ComplexSizeThresholdTSNPCD;
    this.GExpThresholdTSNPCD = GExpThresholdTSNPCD;
    //used in DFM-CIN
    this.SThresholdDFMCIN = SThresholdDFMCIN;
    this.SMinDFMCIN = SMinDFMCIN;
    this.SMaxDFMCIN = SMaxDFMCIN;	
    
    this.algorithm=algorithm;
  }

  public ParameterSet copy()
  {
	  ParameterSet newParam = new ParameterSet();
	  newParam.setScope(this.scope); 
	  newParam.setSelectedNodes(this.selectedNodes); 
	  newParam.setOptimize(this.isOptimize()); 
	  
	  //used in clustering using TSN-PCD
	  newParam.setFThresholdTSNPCD(this.FThresholdTSNPCD);
	  newParam.setComplexSizeThresholdTSNPCD(this.ComplexSizeThresholdTSNPCD);
	  newParam.setGExpThresholdTSNPCD(this.GExpThresholdTSNPCD);
	  //used in DFM-CIN
	  newParam.setSThresholdDFMCIN(this.SThresholdDFMCIN);
	  newParam.setSMinDFMCIN(this.SMinDFMCIN);
	  newParam.setSMaxDFMCIN(this.SMaxDFMCIN);	
	  
	  newParam.setAlgorithm(this.algorithm);
	  return newParam;
  }



public String getScope() {
	return scope;
}




public void setScope(String scope) {
	this.scope = scope;
}




public Long[] getSelectedNodes() {
	return selectedNodes;
}




public void setSelectedNodes(Long[] selectedNodes) {
	this.selectedNodes = selectedNodes;
}




public boolean isOptimize() {
	return optimize;
}




public void setOptimize(boolean optimize) {
	this.optimize = optimize;
}




public double getFThresholdTSNPCD() {
	return FThresholdTSNPCD;
}




public void setFThresholdTSNPCD(double fThresholdTSNPCD) {
	FThresholdTSNPCD = fThresholdTSNPCD;
}




public int getComplexSizeThresholdTSNPCD() {
	return ComplexSizeThresholdTSNPCD;
}




public void setComplexSizeThresholdTSNPCD(int complexSizeThresholdTSNPCD) {
	ComplexSizeThresholdTSNPCD = complexSizeThresholdTSNPCD;
}




public double getGExpThresholdTSNPCD() {
	return GExpThresholdTSNPCD;
}




public void setGExpThresholdTSNPCD(double gExpThresholdTSNPCD) {
	GExpThresholdTSNPCD = gExpThresholdTSNPCD;
}




public double getSThresholdDFMCIN() {
	return SThresholdDFMCIN;
}




public void setSThresholdDFMCIN(double sThresholdDFMCIN) {
	SThresholdDFMCIN = sThresholdDFMCIN;
}




public int getSMinDFMCIN() {
	return SMinDFMCIN;
}




public void setSMinDFMCIN(int sMinDFMCIN) {
	SMinDFMCIN = sMinDFMCIN;
}




public int getSMaxDFMCIN() {
	return SMaxDFMCIN;
}




public void setSMaxDFMCIN(int sMaxDFMCIN) {
	SMaxDFMCIN = sMaxDFMCIN;
}




public String getAlgorithm() {
	return algorithm;
}




public void setAlgorithm(String algorithm) {
	this.algorithm = algorithm;
}




public String toString()
{
  String lineSep = System.getProperty("line.separator");
  StringBuffer sb = new StringBuffer();
  sb.append("   scope: " + this.scope + lineSep);
  sb.append("   Cluster Finding:" + lineSep);
  return sb.toString();
}


}

