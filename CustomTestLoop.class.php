<?php

require_once( 'LoadTestingTest.class.php' );

class CustomTest extends LoadTestingTest
{
  public function startTest()
  {
    for ( $x = 1; $x <= 100; $x++ )
    {
      echo "Iteration $x ";
        $startTime = time();
        sleep( mt_rand( 2, 5 ) );
        $diff = microtime( true ) - $startTime;
      echo " ($startTime)-- ($diff)" . PHP_EOL;
        recordPageTime( $startTime, $diff );
        recordURLPageLoad( $x, $startTime, $diff );
      echo "REcording complete";
    }

    return true;
  }
}