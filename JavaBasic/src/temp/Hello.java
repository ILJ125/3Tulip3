package temp;

public class Hello {

	public static void main(String[] args) {
	
		 {

		      int i = 0, j = 0, k = 0;

		      OUTER : for( i=0; i < 10 ; i++ )

		           MIDDLE : for ( j=0; j < 3; j++ )

		               INNER : for ( k=0; k < 4; k++ ) {

		                    if( i==4 && j ==2 ) break OUTER;

		               }

		           System.out.println( i );

		System.out.println( j );

		System.out.println(k );
	
		 }

	}
	
}
