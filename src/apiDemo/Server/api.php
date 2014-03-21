<?php
	include "config.php";

	foreach($_GET as $str)
		$str = inputFilter($str);
    if(isset($_GET['command']))
    {
        switch($_GET['command'])
        {
            case 'getDate':
                $returnArray = (new DateCommand)->exec($_GET);
                break;
            case 'sumNumber':
                $returnArray = (new SumCalcCommand)->exec($_GET);
                break;
            default:
                $returnArray['state']="ERROR";
                break;
        }
    }
    else
    {
        $returnArray['state']="ERROR";
    }
    
    echo json_encode($returnArray,JSON_PRETTY_PRINT);
?>