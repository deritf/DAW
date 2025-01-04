<?php

namespace Clases1;

class ClasesOperacionesService extends \SoapClient
{

    /**
     * @var array $classmap The defined classes
     */
    private static $classmap = array (
);

    /**
     * @param array $options A array of config values
     * @param string $wsdl The wsdl file to use
     */
    public function __construct(array $options = array(), $wsdl = null)
    {
    
  foreach (self::$classmap as $key => $value) {
    if (!isset($options['classmap'][$key])) {
      $options['classmap'][$key] = $value;
    }
  }
      $options = array_merge(array (
  'features' => 1,
), $options);
      if (!$wsdl) {
        $wsdl = 'C:/xampp/htdocs/realizandoejercicio6v2/servidorSoap/servicio.wsdl';
      }
      parent::__construct($wsdl, $options);
    }

    /**
     * @param anyType $id
     * @return anyType
     */
    public function getPVP($id)
    {
      return $this->__soapCall('getPVP', array($id));
    }

    /**
     * @param anyType $producto
     * @param anyType $tienda
     * @return anyType
     */
    public function getStock($producto, $tienda)
    {
      return $this->__soapCall('getStock', array($producto, $tienda));
    }

    /**
     * @return anyType
     */
    public function getFamilias()
    {
      return $this->__soapCall('getFamilias', array());
    }

    /**
     * @param anyType $codFamilia
     * @return anyType
     */
    public function getProductosFamilia($codFamilia)
    {
      return $this->__soapCall('getProductosFamilia', array($codFamilia));
    }

}
