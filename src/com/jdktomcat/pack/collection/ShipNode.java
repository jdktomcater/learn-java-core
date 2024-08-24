package com.jdktomcat.pack.collection;

/**
 * 类描述：跳表节点
 *
 * @author 汤旗
 * @date 2019-05-17 21:17
 */
public class ShipNode {
    /**
     * 值节点
     */
    private Node valueNode;

    /**
     * 左节点
     */
    private ShipNode leftShipNode;

    /**
     * 下节点
     */
    private ShipNode downShipNode;

    public ShipNode(Node valueNode, ShipNode leftShipNode, ShipNode downShipNode) {
        this.valueNode = valueNode;
        this.leftShipNode = leftShipNode;
        this.downShipNode = downShipNode;
    }

    public Node getValueNode() {
        return valueNode;
    }

    public void setValueNode(Node valueNode) {
        this.valueNode = valueNode;
    }

    public ShipNode getLeftShipNode() {
        return leftShipNode;
    }

    public void setLeftShipNode(ShipNode leftShipNode) {
        this.leftShipNode = leftShipNode;
    }

    public ShipNode getDownShipNode() {
        return downShipNode;
    }

    public void setDownShipNode(ShipNode downShipNode) {
        this.downShipNode = downShipNode;
    }
}
