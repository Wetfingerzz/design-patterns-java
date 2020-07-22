package com.example.patterns2.decorator.taxiportal;

import org.junit.Assert;
import org.junit.Test;

import javax.websocket.RemoteEndpoint;
import java.math.BigDecimal;

public class TaxiOrderTestSuite {

    @Test
    public void testBasicTaxiOrderGetCost() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        //when
        BigDecimal calculatedCost = order.getCost();
        //then
        Assert.assertEquals(calculatedCost, new BigDecimal(5));
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        //when
        String message = order.getDescription();
        //then
        Assert.assertEquals(message, "Drive a regular course");
    }

    @Test
    public void testBasicTaxiOrderGetCostByTaxiNetwork() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        //when
        BigDecimal calculatedCost = order.getCost();
        //then
        Assert.assertEquals(calculatedCost,new BigDecimal(40));
    }
    @Test
    public void testBasicTaxiOrderGetDescriptionByTaxiNetwork() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        //when
        String description = order.getDescription();
        //then
        Assert.assertEquals(description, "Drive a regular course by Taxi Network");
    }
    @Test
    public void testBasicOrderGetCostByUberNetwork() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        order = new UberNetworkOrderDecorator(order);
        //when
        BigDecimal calculatedCost = order.getCost();
        //then
        Assert.assertEquals(calculatedCost,new BigDecimal(25));
    }
    @Test
    public void testBasicOrderGetDescriptionByUberNetwork() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        order = new UberNetworkOrderDecorator(order);
        //when
        String description = order.getDescription();
        //then
        Assert.assertEquals(description, "Drive a regular course by Uber Network");
    }
    @Test
    public void testBasicOrderGetCostByMyTaxiNetwork() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        //when
        BigDecimal calculatedCost = order.getCost();
        //then
        Assert.assertEquals(calculatedCost,new BigDecimal(35));
    }
    @Test
    public void testBasicOrderGetDescriptionByMyTaxiNetwork() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        //when
        String description = order.getDescription();
        //then
        Assert.assertEquals(description, "Drive a regular course by MyTaxi Network");
    }
    @Test
    public void testMyTaxiBasicOrderGetCostWithChildSeat() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        //when
        BigDecimal calculatedCost = order.getCost();
        //then
        Assert.assertEquals(calculatedCost, new BigDecimal(37));
    }
    @Test
    public void testMyTaxiBasicOrderGetDescriptionWithChildSeat() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        //when
        String description = order.getDescription();
        //then
        Assert.assertEquals(description, "Drive a regular course by MyTaxi Network + child seat");
    }
    @Test
    public void testUberBasicOrderCostWithDoubleChildSeats() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        order = new UberNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        order = new ChildSeatDecorator(order);
        //when
        BigDecimal calculatedCost = order.getCost();
        //then
        Assert.assertEquals(calculatedCost,new BigDecimal(29));
    }
    @Test
    public void testVipTaxiNetworkWithChildSeatExpressServiceGetCost() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        order = new VipCarDecorator(order);
        order = new ChildSeatDecorator(order);
        order = new ExpressDecorator(order);
        //when
        BigDecimal calculatedCost = order.getCost();
        //then
        Assert.assertEquals(calculatedCost, new BigDecimal(57));
    }
    @Test
    public void testVipTaxiNetworkWithChildSeatExpressServiceGetDescription() {
        //given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        order = new VipCarDecorator(order);
        order = new ChildSeatDecorator(order);
        order = new ExpressDecorator(order);
        //when
        String description = order.getDescription();
        //then
        Assert.assertEquals(description, "Drive a regular course by Taxi Network VIP variant + child seat express service");
    }
}
