<?php

require '../vendor/autoload.php';

use Jenssegers\Blade\Blade;

$views = '../views';
$cache = '../cache';
$blade = new Blade($views, $cache);

echo $blade->render('vinstalacion');