package edu.udg.caes;

import java.util.Vector;

public class Exercise2 {

    /**
     * Vector union operation
     *
     *  @param a first vector
     *  @param b second vector
     *  @return objects that are in either one of the two argument vectors
     */
    public static Vector union (Vector a, Vector b)
    {
        Vector finalVector = new Vector();

        if( a == null && b != null )
        {
            finalVector = b;
        }
        else if( b == null && a != null )
        {
            finalVector = a;
        }
        else if( a == null && b == null )
        {
            throw new NullPointerException();
        }
        else
        {
            if( a.contains( null ) || b.contains( null ) )
            {
                throw new NullPointerException();
            }
            else
            {
                finalVector.addAll( a );
                for( Object obj : b )
                {
                    if( !finalVector.contains( obj ) ) finalVector.add( obj );
                }
            }
        }

        return finalVector;
    }

}
