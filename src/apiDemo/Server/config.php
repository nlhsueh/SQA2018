<?php
	header('Content-type: application/json');

	foreach (glob("command/*.php") as $filename)
		include $filename;
		
	function inputFilter($str)
	{
		return strip_tags(addslashes(trim($str)));
	}
	function microtime_float()
    {
        list($usec, $sec) = explode(" ", microtime());
        return round(((float)$usec + (float)$sec)*1000);
    }
	
?>