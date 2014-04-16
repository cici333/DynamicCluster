package org.cytoscape.DynamicCluster.internal;


import java.util.HashMap;
import java.util.Map;

public class CurrentParameters
{
  private Map<Long, ParameterSet> currentParams = new HashMap<Long, ParameterSet>();
 

private Map<Integer, ParameterSet> resultParams = new HashMap<Integer, ParameterSet>();

  public ParameterSet getParamsCopy(Long networkID)
  {
    if (networkID != null) {
      return ((ParameterSet)this.currentParams.get(networkID)).copy();
    }
    ParameterSet newParams = new ParameterSet();
    return newParams.copy();
  }

  /**
   * Put newParams into the currentParams together with networkID, and into resultParams together with resultID
   * */ 
  public void setParams(ParameterSet newParams, int resultId, Long networkID)
  {
    ParameterSet currentParamSet = new ParameterSet(
    		newParams.getScope(), 
    		newParams.getSelectedNodes(), 
    		newParams.isOptimize(), 

   		//used in clustering using TSN-PCD
    		newParams.getFThresholdTSNPCD(),
    		newParams.getComplexSizeThresholdTSNPCD(),
    		newParams.getGExpThresholdTSNPCD(),

    		//used in DFM-CIN
    		newParams.getSThresholdDFMCIN(),
    		newParams.getSMinDFMCIN(),
    		newParams.getSMaxDFMCIN(),
    		
    		newParams.getAlgorithm());

    this.currentParams.put(networkID, currentParamSet);

    ParameterSet resultParamSet = new ParameterSet(
    		newParams.getScope(), 
    		newParams.getSelectedNodes(), 
    		newParams.isOptimize(), 
    		
   		//used in clustering using TSN-PCD
    		newParams.getFThresholdTSNPCD(),
    		newParams.getComplexSizeThresholdTSNPCD(),
    		newParams.getGExpThresholdTSNPCD(),

    		//used in DFM-CIN
    		newParams.getSThresholdDFMCIN(),
    		newParams.getSMinDFMCIN(),
    		newParams.getSMaxDFMCIN(),
    		
    		newParams.getAlgorithm()
    		);

    this.resultParams.put(Integer.valueOf(resultId), resultParamSet);
  }

  public ParameterSet getResultParams(int resultId) {
    return ((ParameterSet)this.resultParams.get(Integer.valueOf(resultId))).copy();
  }

  public void removeResultParams(int resultId) {
    this.resultParams.remove(Integer.valueOf(resultId));
  }
  
  
  public Map<Long, ParameterSet> getAllParamSets() {
		return currentParams;
	}
}