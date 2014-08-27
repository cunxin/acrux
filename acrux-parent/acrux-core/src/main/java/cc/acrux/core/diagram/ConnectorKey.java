/**
 * 
 */
package cc.acrux.core.diagram;

import java.io.Serializable;

/**
 * @author Alan
 *
 */
public class ConnectorKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String upstreamId;
	
	private String downstreamId;

	public String getUpstreamId() {
		return upstreamId;
	}

	public void setUpstreamId(String upstreamId) {
		this.upstreamId = upstreamId;
	}

	public String getDownstreamId() {
		return downstreamId;
	}

	public void setDownstreamId(String downstreamId) {
		this.downstreamId = downstreamId;
	}
}
