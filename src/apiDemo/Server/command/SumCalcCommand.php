<?php
	class SumCalcCommand extends AbstractCommand
	{
		function sum($GETinput)
		{
            $sum = 0;
            $calcS ="";
            $calcN =""; 
            foreach($GETinput as $key => $value)
            {
                if($key=="command")
                    continue;
                if(is_numeric($value))
                {
                    $calcS .= $key . " + ";
                    $calcN .= $value . " + "; 
                    $sum+=(int)$value;
                }
                else
                    return null;
            }
            $data['calcS'] = trim($calcS,"+ "); 
			$data['calcN'] = trim($calcN,"+ "); 
			$data['sum'] = $sum; 
			return $data;
		}
        function exec($GETinput)
        {
            $returnData['command'] = "SumCalcCommand";
            $returnData['state'] = "Success";
            $returnData['timestamp'] = microtime_float();
            $returnData['data'] =  $this->sum($GETinput);
            if($returnData['data']==null)
            {
                $returnData['state']="ERROR!";
            }
            return $returnData;
        }
	}


?>