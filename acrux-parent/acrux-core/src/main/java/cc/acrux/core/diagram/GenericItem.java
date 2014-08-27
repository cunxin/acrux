/**
 * 
 */
package cc.acrux.core.diagram;

import java.io.Serializable;

/**
 * @author Alan
 *
 */
public class GenericItem<I extends Serializable> implements Item<I> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3173354257285404389L;
	
	private Diagram diagram;
	
	private I id;

	/*
	 * (non-Javadoc)
	 * @see io.kasa.core.persistence.IEntity#getId()
	 */
	@Override
	public I getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * @see io.kasa.core.persistence.IEntity#setId(java.io.Serializable)
	 */
	@Override
	public void setId(I id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * @see io.kasa.core.diagram.Item#getDiagram()
	 */
	@Override
	public Diagram getDiagram() {
		return diagram;
	}

	/*
	 * (non-Javadoc)
	 * @see io.kasa.core.diagram.Item#setDiagram(io.kasa.core.diagram.Diagram)
	 */
	@Override
	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}

	
}
