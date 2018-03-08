package eda;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LindkList1Teste {
	private LinkdList1 lista;
	
	@Before
	public void setUp() {
		this.lista = new LinkdList1();
	}
	@Test
	public void add() {
		this.lista.add(1);
		this.lista.add(2);
		this.lista.add(3);
		this.lista.add(4);
		this.lista.add(5);
		Assert.assertEquals(5, lista.size());

	}
	@Test
	public void remove() {
		this.lista.add(1);
		this.lista.add(2);
		this.lista.add(3);
		this.lista.add(4);
		this.lista.add(5);
		assertEquals(5, lista.size());
		this.lista.removeLast();
		assertEquals(4, lista.size());
	}
	
	@Test
	public void testeToString() {
		this.lista.add(1);
		this.lista.add(2);
		this.lista.add(3);
		this.lista.add(4);
		this.lista.add(5);
		assertEquals(5, lista.size());
		assertEquals("1 2 3 4 5", lista.toString());

	}
	
	@Test
	public void reverye() {
		this.lista.add(1);
		this.lista.add(2);
		this.lista.add(3);
		this.lista.add(4);
		this.lista.add(5);
		assertEquals("1 2 3 4 5", lista.toString());
		lista.inverte();
		assertEquals("5 4 3 2 1", lista.toString());

	}



}
