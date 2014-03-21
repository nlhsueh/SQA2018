<?php
	class DateCommand extends AbstractCommand
	{
		function getDate()
		{
            $str = date("Y-m-d H:i:s");
			$data['datetime'] =  $str ; 
			return $data;
		}
        function exec($GETinput)
        {
            $returnData['command'] = "DateCommand";
            $returnData['state'] = "Success";
            $returnData['timestamp'] = microtime_float();
            $returnData['data'] = $this->getDate();
            return $returnData;
        }
        
	}


?>