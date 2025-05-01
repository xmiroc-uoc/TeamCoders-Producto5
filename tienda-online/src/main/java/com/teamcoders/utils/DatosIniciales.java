package com.teamcoders.utils;

import java.time.LocalDateTime;

import com.teamcoders.modelo.Articulo;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.ClienteEstandar;
import com.teamcoders.modelo.ClientePremium;
import com.teamcoders.modelo.Datos;
import com.teamcoders.modelo.Pedido;

/**
 * Clase utilitaria para cargar datos de prueba al iniciar la aplicación.
 * Incluye registros de clientes, artículos y pedidos simulados para facilitar
 * las pruebas.
 */
public class DatosIniciales {

        /**
         * Carga datos de ejemplo en las estructuras dinámicas de la clase Datos.
         * Incluye 50 clientes, 50 artículos y múltiples pedidos asignados a ellos.
         * Este método debe ejecutarse una única vez al inicio del programa.
         */
        public static void cargar() {

                // === CLIENTES DE PRUEBA ===
                // Se crean instancias de ClienteEstandar y ClientePremium con distintos
                // atributos

                Cliente c1 = new ClienteEstandar("Ana", "Calle Falsa 123", "12345678A", "ana@email.com");
                Datos.getClientes().add(c1);
                Cliente c2 = new ClientePremium("Luis", "Avenida Real 456", "87654321B", "luis@email.com", 30);
                Datos.getClientes().add(c2);
                Cliente c3 = new ClienteEstandar("Jose Manuel", "Via de Florina Lobato 313 Puerta 3 , Girona, 57241",
                                "85779209P", "susanita70@hotmail.com");
                Datos.getClientes().add(c3);
                Cliente c4 = new ClienteEstandar("Clímaco", "Pasaje Casandra Maestre 6, Barcelona, 38972", "04634663M",
                                "kalamo@gmail.com");
                Datos.getClientes().add(c4);
                Cliente c5 = new ClienteEstandar("Selena", "Ronda de Poncio Granados 8, Ávila, 35373", "88419957N",
                                "fajardozaida@gmail.com");
                Datos.getClientes().add(c5);
                Cliente c6 = new ClienteEstandar("Zaira", "Pasaje de Pepe Teruel 53 Puerta 2 , Las Palmas, 31555",
                                "33540256E",
                                "izquierdoagustin@pulido.com");
                Datos.getClientes().add(c6);
                Cliente c7 = new ClientePremium("Marciano", "Paseo Xiomara Higueras 78, Lugo, 95780", "68684311Z",
                                "romulomorcillo@hotmail.com", 30);
                Datos.getClientes().add(c7);
                Cliente c8 = new ClientePremium("Clarisa", "Paseo Benigna Isern 67, Segovia, 00128", "73372089A",
                                "telmo84@herrera.com", 30);
                Datos.getClientes().add(c8);
                Cliente c9 = new ClientePremium("Emilia", "Cañada de Augusto Ferrández 8, Cádiz, 12366", "36980342C",
                                "calista56@villalonga.com", 30);
                Datos.getClientes().add(c9);
                Cliente c10 = new ClienteEstandar("Albert", "Cuesta de Carlota Anaya 35 Piso 6 , Ourense, 82266",
                                "29484897N",
                                "anitahoyos@gmail.com");
                Datos.getClientes().add(c10);
                Cliente c11 = new ClienteEstandar("Toribio", "Rambla de Bernabé Priego 589 Apt. 27 , Barcelona, 47281",
                                "00308570V", "casanovassamanta@hotmail.com");
                Datos.getClientes().add(c11);
                Cliente c12 = new ClientePremium("Bernabé", "Acceso de Haydée Bello 36 Apt. 49 , Barcelona, 21292",
                                "65132486J",
                                "selena25@yahoo.com", 30);
                Datos.getClientes().add(c12);
                Cliente c13 = new ClientePremium("Marcos", "Via de Vinicio Recio 28, Soria, 84018", "37022637T",
                                "cuencaflor@yahoo.com", 30);
                Datos.getClientes().add(c13);
                Cliente c14 = new ClientePremium("Alberto",
                                "Urbanización de Ramiro Benavente 301 Apt. 85 , Sevilla, 25597",
                                "94782628C", "fausto21@yahoo.com", 30);
                Datos.getClientes().add(c14);
                Cliente c15 = new ClienteEstandar("Teófilo", "Avenida Conrado Torrens 53 Piso 9 , Sevilla, 44341",
                                "94341991L",
                                "pioctavia@roman.org");
                Datos.getClientes().add(c15);
                Cliente c16 = new ClienteEstandar("Camilo", "Pasadizo Emiliana Gras 98 Apt. 35 , Lugo, 48773",
                                "47856012R",
                                "joaquinplana@perera.com");
                Datos.getClientes().add(c16);
                Cliente c17 = new ClientePremium("Natalio", "Pasaje de Noa Cases 506 Piso 9 , Valencia, 47793",
                                "40131672Z",
                                "utorre@yahoo.com", 30);
                Datos.getClientes().add(c17);
                Cliente c18 = new ClienteEstandar("Inés", "Callejón de Cebrián Sancho 93, Toledo, 52896", "78644654P",
                                "borja47@hotmail.com");
                Datos.getClientes().add(c18);
                Cliente c19 = new ClientePremium("Primitivo", "Pasaje de Hernán Iborra 46, Navarra, 62987", "28037367X",
                                "wmoraleda@arroyo-daza.es", 30);
                Datos.getClientes().add(c19);
                Cliente c20 = new ClientePremium("Marina", "C. de Erasmo Villa 74 Apt. 35 , Ávila, 37191", "71188509N",
                                "violetamate@guardiola-sureda.org", 30);
                Datos.getClientes().add(c20);
                Cliente c21 = new ClienteEstandar("Zoraida", "Alameda de Herberto Montenegro 92, Girona, 24326",
                                "22976230D",
                                "lupitaalcazar@gmail.com");
                Datos.getClientes().add(c21);
                Cliente c22 = new ClienteEstandar("Sofía", "Plaza Leticia Múgica 96 Apt. 11 , Valencia, 70505",
                                "95570399V",
                                "adolfo35@yahoo.com");
                Datos.getClientes().add(c22);
                Cliente c23 = new ClientePremium("Bienvenida", "Alameda de Marco Roig 97, Soria, 79486", "21038992T",
                                "lastrajuan-carlos@yahoo.com", 30);
                Datos.getClientes().add(c23);
                Cliente c24 = new ClienteEstandar("Martin", "Via Olimpia Montenegro 6 Puerta 9 , Cuenca, 89425",
                                "48132979N",
                                "ameliazurita@olivares-giron.com");
                Datos.getClientes().add(c24);
                Cliente c25 = new ClientePremium("Lina", "Cañada Pili Zapata 52, Sevilla, 58703", "13196037A",
                                "qgalindo@gmail.com", 30);
                Datos.getClientes().add(c25);
                Cliente c26 = new ClienteEstandar("Dionisio", "Glorieta Arturo Armas 471 Apt. 06 , Burgos, 48639",
                                "16370376Y",
                                "vcobo@fabregas-saavedra.es");
                Datos.getClientes().add(c26);
                Cliente c27 = new ClienteEstandar("Yaiza", "Avenida de Jose Luis Lledó 1 Apt. 86 , León, 49096",
                                "03523591W",
                                "cllorens@gmail.com");
                Datos.getClientes().add(c27);
                Cliente c28 = new ClientePremium("Evangelina", "Vial de Azahara Sanmartín 43 Piso 1 , Almería, 61870",
                                "05988260H", "juan-pablovillena@gmail.com", 30);
                Datos.getClientes().add(c28);
                Cliente c29 = new ClientePremium("Matías", "Avenida de Ainoa Gual 92 Piso 6 , Tarragona, 93658",
                                "30237251Z",
                                "bernardomorales@zabala-robledo.com", 30);
                Datos.getClientes().add(c29);
                Cliente c30 = new ClientePremium("Ramona", "Avenida de Estrella Sáez 61, Ceuta, 96226", "10595687Z",
                                "hrosa@machado.org", 30);
                Datos.getClientes().add(c30);
                Cliente c31 = new ClientePremium("Benigno",
                                "Urbanización de Apolonia Oller 23 Piso 2 , Barcelona, 03460",
                                "22442120E", "wvillegas@yahoo.com", 30);
                Datos.getClientes().add(c31);
                Cliente c32 = new ClienteEstandar("Lina", "Urbanización Alex Codina 31 Apt. 75 , Soria, 72025",
                                "49493721L",
                                "vilaltageraldo@yahoo.com");
                Datos.getClientes().add(c32);
                Cliente c33 = new ClientePremium("Ambrosio", "Via de Victorino Parejo 45 Puerta 4 , Ávila, 25405",
                                "91249396D",
                                "jonatanborja@bosch-fernandez.es", 30);
                Datos.getClientes().add(c33);
                Cliente c34 = new ClientePremium("Marciano", "Callejón Yago Fernandez 5, Lugo, 96336", "64172245X",
                                "yrivas@santamaria-tirado.es", 30);
                Datos.getClientes().add(c34);
                Cliente c35 = new ClientePremium("Luciana", "Alameda Zaida Rojas 5 Apt. 07 , Albacete, 47475",
                                "73931119Q",
                                "casandrapazos@pascual-rodrigo.es", 30);
                Datos.getClientes().add(c35);
                Cliente c36 = new ClientePremium("Jordana", "C. Custodia Gual 366 Piso 0 , Murcia, 12704", "14371034E",
                                "mariscalodalis@yahoo.com", 30);
                Datos.getClientes().add(c36);
                Cliente c37 = new ClientePremium("Goyo", "Calle Hilda Santamaría 45 Apt. 28 , Sevilla, 31514",
                                "20882157K",
                                "ferrandizpelayo@yahoo.com", 30);
                Datos.getClientes().add(c37);
                Cliente c38 = new ClientePremium("Amancio", "Paseo de Edmundo Comas 64, Lugo, 53429", "66295948E",
                                "armando17@montoya.es", 30);
                Datos.getClientes().add(c38);
                Cliente c39 = new ClienteEstandar("Ignacia", "Alameda Reyes Marí 99, Guadalajara, 01789", "45794891A",
                                "pacacamino@prats-murillo.net");
                Datos.getClientes().add(c39);
                Cliente c40 = new ClienteEstandar("Teófilo", "Avenida Modesta Donoso 4, La Rioja, 86480", "97004396L",
                                "nereaarjona@yahoo.com");
                Datos.getClientes().add(c40);
                Cliente c41 = new ClientePremium("Guiomar", "Cuesta Pastora Solera 774 Piso 6 , Valladolid, 71912",
                                "33790926G",
                                "imeldallanos@gmail.com", 30);
                Datos.getClientes().add(c41);
                Cliente c42 = new ClientePremium("Buenaventura", "Camino de Fito Hierro 86, Palencia, 16286",
                                "19310549R",
                                "eutimiocapdevila@carmona.org", 30);
                Datos.getClientes().add(c42);
                Cliente c43 = new ClientePremium("Azeneth", "Cañada Ciriaco Mateos 68 Apt. 10 , Zamora, 82113",
                                "15603286H",
                                "sotoruth@rodriguez.com", 30);
                Datos.getClientes().add(c43);
                Cliente c44 = new ClientePremium("Sandra", "C. Ambrosio Sevillano 87 Puerta 3 , Sevilla, 80823",
                                "29623174J",
                                "rosalva86@gmail.com", 30);
                Datos.getClientes().add(c44);
                Cliente c45 = new ClienteEstandar("Alonso",
                                "Pasaje Francisco Jose Carpio 6 Apt. 50 , Las Palmas, 02540",
                                "13797010P", "bsegarra@olive.com");
                Datos.getClientes().add(c45);
                Cliente c46 = new ClientePremium("Domingo", "Cuesta Guadalupe Chacón 57, Albacete, 88548", "67482623W",
                                "borja16@bayon-pedraza.com", 30);
                Datos.getClientes().add(c46);
                Cliente c47 = new ClienteEstandar("Jacinto", "Avenida Ceferino Esteban 3 Puerta 6 , Baleares, 50644",
                                "27486020X", "eibanez@font.es");
                Datos.getClientes().add(c47);
                Cliente c48 = new ClienteEstandar("Guadalupe", "Plaza de Victorino Jara 3 Apt. 89 , Sevilla, 16627",
                                "97229957V", "heribertoreina@juan-figueras.com");
                Datos.getClientes().add(c48);
                Cliente c49 = new ClientePremium("Amada", "Vial Cándida Pascual 642, Ceuta, 58324", "49783583M",
                                "jcamara@andreu-riquelme.com", 30);
                Datos.getClientes().add(c49);
                Cliente c50 = new ClienteEstandar("Natividad", "Ronda Maxi Peña 93, Cantabria, 45255", "61365041K",
                                "loreto62@tamarit.net");
                Datos.getClientes().add(c50);

                // === ARTÍCULOS DE PRUEBA ===
                // Se generan artículos con distintos códigos, precios y tiempos de preparación

                Articulo a1 = new Articulo("A001", 30, 12.0, 1200.0, "Laptop");
                Datos.getArticulos().add(a1);
                Articulo a2 = new Articulo("A002", 15, 15.0, 800.0, "Smartphone");
                Datos.getArticulos().add(a2);
                Articulo a3 = new Articulo("A100", 49, 8.25, 758.79, "Consequatur");
                Datos.getArticulos().add(a3);
                Articulo a4 = new Articulo("A101", 43, 11.76, 1116.29, "Enim");
                Datos.getArticulos().add(a4);
                Articulo a5 = new Articulo("A102", 33, 19.52, 1451.28, "Officiis");
                Datos.getArticulos().add(a5);
                Articulo a6 = new Articulo("A103", 12, 19.48, 907.03, "Itaque");
                Datos.getArticulos().add(a6);
                Articulo a7 = new Articulo("A104", 45, 10.58, 764.14, "Cupiditate");
                Datos.getArticulos().add(a7);
                Articulo a8 = new Articulo("A105", 24, 13.85, 275.08, "Repellat");
                Datos.getArticulos().add(a8);
                Articulo a9 = new Articulo("A106", 33, 16.3, 1429.6, "Autem");
                Datos.getArticulos().add(a9);
                Articulo a10 = new Articulo("A107", 34, 14.2, 909.04, "Nisi");
                Datos.getArticulos().add(a10);
                Articulo a11 = new Articulo("A108", 45, 16.43, 137.56, "Error");
                Datos.getArticulos().add(a11);
                Articulo a12 = new Articulo("A109", 14, 5.63, 643.88, "Aliquid");
                Datos.getArticulos().add(a12);
                Articulo a13 = new Articulo("A110", 42, 16.33, 135.93, "Enim");
                Datos.getArticulos().add(a13);
                Articulo a14 = new Articulo("A111", 50, 15.48, 1379.63, "Cupiditate");
                Datos.getArticulos().add(a14);
                Articulo a15 = new Articulo("A112", 46, 9.16, 1450.55, "Minus");
                Datos.getArticulos().add(a15);
                Articulo a16 = new Articulo("A113", 40, 15.09, 323.08, "Dignissimos");
                Datos.getArticulos().add(a16);
                Articulo a17 = new Articulo("A114", 10, 14.9, 1201.07, "Eos");
                Datos.getArticulos().add(a17);
                Articulo a18 = new Articulo("A115", 35, 5.42, 1042.27, "Suscipit");
                Datos.getArticulos().add(a18);
                Articulo a19 = new Articulo("A116", 31, 6.26, 196.4, "Repellat");
                Datos.getArticulos().add(a19);
                Articulo a20 = new Articulo("A117", 35, 8.01, 1402.42, "Beatae");
                Datos.getArticulos().add(a20);
                Articulo a21 = new Articulo("A118", 53, 17.32, 476.51, "Minima");
                Datos.getArticulos().add(a21);
                Articulo a22 = new Articulo("A119", 32, 14.97, 1453.17, "Maiores");
                Datos.getArticulos().add(a22);
                Articulo a23 = new Articulo("A120", 43, 9.35, 415.32, "Inventore");
                Datos.getArticulos().add(a23);
                Articulo a24 = new Articulo("A121", 14, 14.04, 1254.35, "Consequuntur");
                Datos.getArticulos().add(a24);
                Articulo a25 = new Articulo("A122", 10, 12.72, 1177.28, "Unde");
                Datos.getArticulos().add(a25);
                Articulo a26 = new Articulo("A123", 45, 17.41, 968.89, "Quae");
                Datos.getArticulos().add(a26);
                Articulo a27 = new Articulo("A124", 34, 11.79, 632.98, "Necessitatibus");
                Datos.getArticulos().add(a27);
                Articulo a28 = new Articulo("A125", 36, 5.77, 1325.24, "Officia");
                Datos.getArticulos().add(a28);
                Articulo a29 = new Articulo("A126", 39, 5.01, 995.91, "Tenetur");
                Datos.getArticulos().add(a29);
                Articulo a30 = new Articulo("A127", 40, 10.47, 352.74, "Exercitationem");
                Datos.getArticulos().add(a30);
                Articulo a31 = new Articulo("A128", 29, 8.32, 629.25, "Nisi");
                Datos.getArticulos().add(a31);
                Articulo a32 = new Articulo("A129", 44, 7.3, 512.95, "Consequuntur");
                Datos.getArticulos().add(a32);
                Articulo a33 = new Articulo("A130", 27, 6.73, 1118.25, "Esse");
                Datos.getArticulos().add(a33);
                Articulo a34 = new Articulo("A131", 14, 16.36, 907.68, "Ex");
                Datos.getArticulos().add(a34);
                Articulo a35 = new Articulo("A132", 17, 5.09, 1174.89, "Reprehenderit");
                Datos.getArticulos().add(a35);
                Articulo a36 = new Articulo("A133", 10, 6.34, 1021.32, "Aspernatur");
                Datos.getArticulos().add(a36);
                Articulo a37 = new Articulo("A134", 21, 5.72, 558.39, "Vero");
                Datos.getArticulos().add(a37);
                Articulo a38 = new Articulo("A135", 44, 13.43, 724.42, "Voluptates");
                Datos.getArticulos().add(a38);
                Articulo a39 = new Articulo("A136", 59, 8.38, 477.96, "Iste");
                Datos.getArticulos().add(a39);
                Articulo a40 = new Articulo("A137", 53, 6.41, 1138.39, "Itaque");
                Datos.getArticulos().add(a40);
                Articulo a41 = new Articulo("A138", 25, 11.85, 1054.15, "Aliquam");
                Datos.getArticulos().add(a41);
                Articulo a42 = new Articulo("A139", 42, 6.61, 1213.05, "Sint");
                Datos.getArticulos().add(a42);
                Articulo a43 = new Articulo("A140", 24, 12.69, 965.7, "Amet");
                Datos.getArticulos().add(a43);
                Articulo a44 = new Articulo("A141", 59, 7.18, 1242.31, "Nesciunt");
                Datos.getArticulos().add(a44);
                Articulo a45 = new Articulo("A142", 38, 14.6, 849.68, "Sapiente");
                Datos.getArticulos().add(a45);
                Articulo a46 = new Articulo("A143", 18, 12.45, 381.93, "Asperiores");
                Datos.getArticulos().add(a46);
                Articulo a47 = new Articulo("A144", 10, 5.03, 784.79, "Autem");
                Datos.getArticulos().add(a47);
                Articulo a48 = new Articulo("A145", 41, 16.7, 1188.22, "Ipsum");
                Datos.getArticulos().add(a48);
                Articulo a49 = new Articulo("A146", 36, 10.62, 590.21, "Nam");
                Datos.getArticulos().add(a49);
                Articulo a50 = new Articulo("A147", 26, 5.93, 119.07, "Facere");
                Datos.getArticulos().add(a50);

                // === PEDIDOS DE PRUEBA ===
                // Se crean pedidos que asocian clientes y artículos ya registrados

                Datos.getPedidos()
                                .add(new Pedido(3, 2, LocalDateTime.of(2025, 04, 11, 12, 50),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("adolfo35@yahoo.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A143"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(4, 4, LocalDateTime.of(2025, 04, 11, 13, 12),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("joaquinplana@perera.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A134"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(5, 4, LocalDateTime.of(2025, 04, 11, 13, 8),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals(
                                                                                "casandrapazos@pascual-rodrigo.es"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A126"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(6, 5, LocalDateTime.of(2025, 04, 11, 13, 02),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("qgalindo@gmail.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A103"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(7, 3, LocalDateTime.of(2025, 04, 11, 12, 38),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("borja47@hotmail.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A116"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(8, 2, LocalDateTime.of(2025, 04, 11, 12, 55),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("izquierdoagustin@pulido.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A137"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(9, 4, LocalDateTime.of(2025, 04, 11, 12, 52),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("eibanez@font.es"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A002"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(10, 3, LocalDateTime.of(2025, 04, 11, 12, 50),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("imeldallanos@gmail.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A124"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(11, 4, LocalDateTime.of(2025, 04, 11, 12, 33),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("ana@email.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A104"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(12, 3, LocalDateTime.of(2025, 04, 11, 12, 26),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("bsegarra@olive.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A113"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(13, 4, LocalDateTime.of(2025, 04, 11, 13, 21),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("telmo84@herrera.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A112"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(14, 1, LocalDateTime.of(2025, 04, 11, 13, 9),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("pioctavia@roman.org"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A138"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(15, 4, LocalDateTime.of(2025, 04, 11, 12, 58),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals(
                                                                                "ameliazurita@olivares-giron.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A110"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(16, 5, LocalDateTime.of(2025, 04, 11, 12, 53),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail()
                                                                                .equals("eutimiocapdevila@carmona.org"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A115"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(17, 1, LocalDateTime.of(2025, 04, 11, 13, 57),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("kalamo@gmail.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A108"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(18, 2, LocalDateTime.of(2025, 04, 11, 12, 24),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("loreto62@tamarit.net"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A002"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(19, 1, LocalDateTime.of(2025, 04, 11, 14, 10),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("cuencaflor@yahoo.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A111"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(20, 2, LocalDateTime.of(2025, 04, 11, 12, 58),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail()
                                                                                .equals("casanovassamanta@hotmail.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A130"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(21, 3, LocalDateTime.of(2025, 04, 11, 12, 29),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("loreto62@tamarit.net"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A116"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(22, 5, LocalDateTime.of(2025, 04, 11, 12, 39),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail()
                                                                                .equals("eutimiocapdevila@carmona.org"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A124"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(23, 1, LocalDateTime.of(2025, 04, 11, 13, 12),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("pioctavia@roman.org"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A136"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(24, 3, LocalDateTime.of(2025, 04, 11, 12, 40),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("jcamara@andreu-riquelme.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A109"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(25, 3, LocalDateTime.of(2025, 04, 11, 13, 55),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("cllorens@gmail.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A123"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(26, 5, LocalDateTime.of(2025, 04, 11, 13, 40),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("romulomorcillo@hotmail.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A136"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(27, 2, LocalDateTime.of(2025, 04, 11, 13, 38),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("jcamara@andreu-riquelme.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A143"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(28, 2, LocalDateTime.of(2025, 04, 11, 12, 32),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("borja16@bayon-pedraza.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A106"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(29, 3, LocalDateTime.of(2025, 04, 11, 13, 13),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail()
                                                                                .equals("pacacamino@prats-murillo.net"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A106"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(30, 4, LocalDateTime.of(2025, 04, 11, 12, 29),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("bsegarra@olive.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A002"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(31, 4, LocalDateTime.of(2025, 04, 11, 13, 49),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("hrosa@machado.org"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A140"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(32, 3, LocalDateTime.of(2025, 04, 11, 13, 9),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail()
                                                                                .equals("pacacamino@prats-murillo.net"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A142"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(33, 3, LocalDateTime.of(2025, 04, 11, 12, 34),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("borja16@bayon-pedraza.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A140"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(34, 4, LocalDateTime.of(2025, 04, 11, 12, 36),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("susanita70@hotmail.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A139"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(35, 1, LocalDateTime.of(2025, 04, 11, 12, 13),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("nereaarjona@yahoo.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A128"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(36, 5, LocalDateTime.of(2025, 04, 11, 13, 05),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("luis@email.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A140"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(37, 2, LocalDateTime.of(2025, 04, 11, 13, 02),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("nereaarjona@yahoo.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A140"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(38, 4, LocalDateTime.of(2025, 04, 11, 12, 19),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("borja47@hotmail.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A115"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(39, 1, LocalDateTime.of(2025, 04, 11, 13, 15),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("qgalindo@gmail.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A120"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(40, 1, LocalDateTime.of(2025, 04, 11, 13, 12),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("nereaarjona@yahoo.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A105"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(41, 4, LocalDateTime.of(2025, 04, 11, 12, 41),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("ferrandizpelayo@yahoo.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A132"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(42, 2, LocalDateTime.of(2025, 04, 11, 12, 26),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail()
                                                                                .equals("casanovassamanta@hotmail.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A105"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(43, 5, LocalDateTime.of(2025, 04, 11, 14, 07),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals(
                                                                                "jonatanborja@bosch-fernandez.es"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A100"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(44, 1, LocalDateTime.of(2025, 04, 11, 13, 54),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals(
                                                                                "heribertoreina@juan-figueras.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A105"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(45, 1, LocalDateTime.of(2025, 04, 11, 14, 10),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("susanita70@hotmail.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A126"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(46, 4, LocalDateTime.of(2025, 04, 11, 13, 26),
                                                Datos.getClientes().stream()
                                                                .filter(x -> x.getEmail().equals("kalamo@gmail.com"))
                                                                .findFirst()
                                                                .get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A125"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(47, 5, LocalDateTime.of(2025, 04, 11, 13, 25),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("juan-pablovillena@gmail.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A145"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(48, 5, LocalDateTime.of(2025, 04, 11, 13, 44),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("mariscalodalis@yahoo.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A138"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(49, 5, LocalDateTime.of(2025, 04, 11, 13, 07),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("juan-pablovillena@gmail.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A114"))
                                                                .findFirst().get()));
                Datos.getPedidos()
                                .add(new Pedido(50, 5, LocalDateTime.of(2025, 04, 11, 13, 55),
                                                Datos.getClientes().stream().filter(
                                                                x -> x.getEmail().equals("fajardozaida@gmail.com"))
                                                                .findFirst().get(),
                                                Datos.getArticulos().stream().filter(x -> x.getCodigo().equals("A001"))
                                                                .findFirst().get()));
        }
}
