package privatezone.eclemma;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DijkstraTest {

	Vertex A;
	Vertex B;
	Vertex D;
	Vertex F;
	Vertex K;
	Vertex J;
	Vertex M;
	Vertex O;
	Vertex P;
	Vertex R;
	Vertex Z;

	@Before
	public void init() {
		// mark all the vertices
		A = new Vertex("A");
		B = new Vertex("B");
		D = new Vertex("D");
		F = new Vertex("F");
		K = new Vertex("K");
		J = new Vertex("J");
		M = new Vertex("M");
		O = new Vertex("O");
		P = new Vertex("P");
		R = new Vertex("R");
		Z = new Vertex("Z");

		// set the edges and weight
		A.adjacencies = new Edge[] { new Edge(M, 8) };
		B.adjacencies = new Edge[] { new Edge(D, 11) };
		D.adjacencies = new Edge[] { new Edge(B, 11) };
		F.adjacencies = new Edge[] { new Edge(K, 23) };
		K.adjacencies = new Edge[] { new Edge(O, 40) };
		J.adjacencies = new Edge[] { new Edge(K, 25) };
		M.adjacencies = new Edge[] { new Edge(R, 8) };
		O.adjacencies = new Edge[] { new Edge(K, 40) };
		P.adjacencies = new Edge[] { new Edge(Z, 18) };
		R.adjacencies = new Edge[] { new Edge(P, 15) };
		Z.adjacencies = new Edge[] { new Edge(P, 18) };
	}

	/*
	 * A to Z
	 */
	@Ignore
	@Test
	public void testComputePaths() {

		Dijkstra.computePaths(A); // run Dijkstra
		// System.out.println("Distance to " + Z + ": " + Z.minDistance);
		assertEquals(49.0, Z.minDistance, 0);
		// List<Vertex> path = Dijkstra.getShortestPathTo(Z);
		// System.out.println("Path: " + path);
		// this.assertEquals("[A, M, R, P, Z]", path.toString());

		// fail("Not yet implemented");
	}

	/*
	 * A to M
	 */
	@Test
	public void testComputePaths2() {

		Dijkstra.computePaths(A); // run Dijkstra
		assertEquals(8.0, M.minDistance, 0);
		List<Vertex> path = Dijkstra.getShortestPathTo(M);
		assertEquals("[A, M]", path.toString()); 
	}

	/*
	 * A to R
	 */
	@Test
	public void testComputePaths3() {

		Dijkstra.computePaths(A); // run Dijkstra
		assertEquals(16.0, M.minDistance, 0);
		List<Vertex> path = Dijkstra.getShortestPathTo(R);
		assertEquals("[A, M, R]", path.toString()); 
	}

	
	@Test
	public void testGetShortestPathTo() {
		// fail("Not yet implemented");
	}

}
