/**
 * 
 */
package cc.acrux.core.diagram;

/**
 * @author cunxin.gz
 *
 */
public class Node extends GenericItem<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3111885119603631772L;
	
	private Connector[] upstream;
	
	private Connector[] downstream;

	public Connector[] getUpstream() {
		return upstream;
	}
	
	public void setUpstream(Connector[] upstream) {
		this.upstream = upstream;
	}

	public Connector[] getDownstream() {
		return downstream;
	}
	
	public void setDownstream(Connector[] downstream) {
		this.downstream = downstream;
	}

}
