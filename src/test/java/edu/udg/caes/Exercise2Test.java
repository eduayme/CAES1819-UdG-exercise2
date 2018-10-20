package edu.udg.caes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;


public class Exercise2Test {

    Vector a = new Vector();
    Vector b = new Vector();

    // Els dos Vectors no poden ser NULL
    @Test
    public void testBothVectorsNull()
    {
        a = null;
        b = null;

        assertThrows( NullPointerException.class, new Executable() {
            public void execute() throws Throwable
            {
                Exercise2.union( a, b );
            }
        } );
    }

    // Un dels Vectors no pot ser NULL
    @Test
    public void testOneVectorNull()
    {
        a = null;

        b.add( 1 );
        b.add( 2 );
        b.add( 3 );

        Vector expected = new Exercise2().union( a, b );
        Vector result = b;

        assertEquals( expected, result );
    }

    // Un dels Vectors conté NULL
    @Test
    public void testOneVectorContainsNull()
    {
        a.add( 1 );
        a.add( 2 );

        b.add( 1 );
        b.add( 2 );
        b.add( null );

        assertThrows( NullPointerException.class, new Executable() {
            public void execute() throws Throwable
            {
                Exercise2.union( a, b );
            }
        } );
    }

    // Els vectors tenen numero repetits
    @Test
    public void testVectorsContainsSameNumber()
    {
        a.add( 1 );
        a.add( 2 );
        a.add( 3 );
        b.add( 1 );
        b.add( 2 );
        b.add( 3 );

        Vector result = new Vector();
        result.add( 1 );
        result.add( 2 );
        result.add( 3 );

        Vector expected = new Exercise2().union( a, b );

        assertEquals( expected, result );
    }
}