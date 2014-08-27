/**
 * 
 */
package cc.acrux.core.diagram;

import java.io.Serializable;

import cc.acrux.core.persistence.IEntity;

/**
 * @author Alan
 *
 */
public interface Item<I extends Serializable> extends IEntity<I> {

	Diagram getDiagram();
	
	void setDiagram(Diagram diagram);
}
