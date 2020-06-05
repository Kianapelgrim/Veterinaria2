import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


class Citas{
    public String nombreCli;
    public String nombreMascota;
    public LocalTime lt;
    public LocalDate ld;
    public boolean cancelled;
}
class Diagnosticos {
    public String nombre;
    public String nombreMascota;
    public String diag;
    public boolean cancel;
}
    class Reportes {
        int tamañocita;
        int tamañodiag;
        Citas[] repCita = new Citas[tamañocita];
        Diagnosticos[] repDiag = new Diagnosticos[tamañodiag];
    }


    public class main {
        public static void main(String[] args) {
            int resp = 0;
            int resp1 = 0;
            int resp2 = 0;
            int resp3 = 0;
            int i = -1;
            int k = -1;
            int respCita = 0;
            int respModificar = 0;
            int modifdiag = 0;
            int cancelardiag = 0;
            Citas[] cita = new Citas[2];
            Diagnosticos[] diag = new Diagnosticos[2];
            String nombre;
            String nombreDiag;
            String nombreMas;
            String masDiag;
            String diagnostico;
            LocalDate date = LocalDate.parse("1999-02-12");
            LocalTime time = LocalTime.parse("12:00");
            cita[0]= new Citas();
            diag[0]= new Diagnosticos();
            do {
                System.out.println("VETERINARIA\n\n1.-Citas\n2.-Diagnósticos\n3.-Reportes\n4.-Salir");
                Scanner lc = new Scanner(System.in);

                boolean valorValido = true;
                do {
                    try {
                        System.out.println("¿Qué desea realizar?");
                        resp = Integer.parseInt(lc.nextLine());
                        valorValido = true;
                    } catch (Exception ex) {
                        System.out.println("Introduzca un valor valido");
                        valorValido = false;
                    }
                } while (valorValido != true);
                switch (resp) {
                    case 1:
                        do {
                            System.out.println("¿Qué desea realizar?\n1.-Agendar Cita \n2.-Re-agendar cita\n3.-Cancelar cita\n4.-Regresar a menú principal");
                            valorValido = true;
                            do {
                                try {
                                    resp1 = Integer.parseInt(lc.nextLine());
                                    valorValido = true;
                                } catch (Exception ex) {
                                    System.out.println("Introduzca un valor valido");
                                    valorValido = false;
                                }
                            } while (valorValido != true);
                            switch (resp1) {
                                case 1:
                                    i++;
                                    System.out.println("Introduzca su nombre");
                                    nombre = lc.nextLine();
                                    System.out.println("Introduzca el nombre de su mascota");
                                    nombreMas = lc.nextLine();
                                    System.out.println("Introduzca la fecha de su cita (Año-Mes-Día, ejm 2001-05-25)");
                                    valorValido = true;
                                    do {
                                        try {
                                            String entrada = lc.nextLine();
                                            date = LocalDate.parse(entrada);
                                            valorValido = true;
                                        } catch (Exception e) {
                                            System.out.println("Introduzca una fecha valida");
                                            valorValido = false;
                                        }
                                    } while (!valorValido);

                                    System.out.println("Introduzca la hora que desea su cita (hh:mm)");

                                    valorValido = true;
                                    do {
                                        try {
                                            String entrada = lc.nextLine();
                                            time = LocalTime.parse(entrada);
                                            valorValido = true;
                                        } catch (Exception e) {
                                            System.out.println("Introduzca un hora válida");
                                            valorValido = false;
                                        }
                                    } while (!valorValido);

                                    if (i < 1) {
                                        cita[i].ld = date;
                                        cita[i].lt = time;
                                        cita[i].nombreCli = nombre;
                                        cita[i].nombreMascota = nombreMas;
                                        cita[i].cancelled = false;
                                    }else{cita=crecer(cita,i,nombre,nombreMas,date,time);}
                                    break;


                                case 2:
                                    for (int j = 0; j < i + 1; j++) {
                                        if (cita[j].cancelled == false)
                                            System.out.println(j + ".-\t" + cita[j].nombreCli + "\t" + cita[j].nombreMascota + "\t" + cita[j].ld + "\t" + cita[j].lt);
                                    }
                                    System.out.println("\n\nIntroduzca el número de cita que gustaría modificar");
                                    valorValido = true;
                                    do {
                                        try {
                                            respCita = Integer.parseInt(lc.nextLine());
                                            valorValido = true;
                                        } catch (Exception ex) {
                                            System.out.println("Introduzca un valor valido");
                                            valorValido = false;
                                        }
                                    } while (valorValido != true);
                                    System.out.println("¿Qué le gustaría modificar?\n\n1.-Nombre\n2.-Nombre de mascota\n3.-Fecha\n4.-Hora");
                                    valorValido = true;
                                    do {
                                        try {
                                            respModificar = Integer.parseInt(lc.nextLine());
                                            valorValido = true;
                                        } catch (Exception ex) {
                                            System.out.println("Introduzca un valor valido");
                                            valorValido = false;
                                        }
                                    } while (valorValido != true);
                                    switch (respModificar) {
                                        case 1:
                                            System.out.println("Introduzca el NOMBRE correcto");
                                            cita[respCita].nombreCli = lc.nextLine();
                                            break;
                                        case 2:
                                            System.out.println("Introduzca el NOMBRE DE MASCOTA correcto");
                                            cita[respCita].nombreMascota = lc.nextLine();
                                            break;
                                        case 3:
                                            System.out.println("Introduzca la FECHA deseada (Año-Mes-Día, ejm 2001-05-25)");
                                            do {
                                                try {
                                                    String entrada = lc.nextLine();
                                                    cita[respCita].ld = LocalDate.parse(entrada);
                                                    valorValido = true;
                                                } catch (Exception e) {
                                                    System.out.println("Introduzca una fecha valida");
                                                    valorValido = false;
                                                }
                                            } while (!valorValido);
                                            break;
                                        case 4:
                                            System.out.println("Introduzca la HORA deseada");
                                            do {
                                                try {
                                                    String entrada = lc.nextLine();
                                                    cita[respCita].lt = LocalTime.parse(entrada);
                                                    valorValido = true;
                                                } catch (Exception e) {
                                                    System.out.println("Introduzca un hora válida");
                                                    valorValido = false;
                                                }
                                            } while (!valorValido);
                                            break;
                                    }
                                    break;
                                case 3:
                                    for (int j = 0; j < i + 1; j++) {
                                        if (cita[j].cancelled == false)
                                            System.out.println(j + ".-\t" + cita[j].nombreCli + "\t" + cita[j].nombreMascota + "\t" + cita[j].ld + "\t" + cita[j].lt);
                                    }
                                    System.out.println("Introduzca el numero de cita que desea cancelar");
                                    do {
                                        try {
                                            respCita = Integer.parseInt(lc.nextLine());
                                            valorValido = true;
                                        } catch (Exception ex) {
                                            System.out.println("Introduzca un valor valido");
                                            valorValido = false;
                                        }
                                    } while (valorValido != true);
                                    cita[respCita].cancelled = true;
                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println("Introduzca un número dentro de las opciones");
                                    break;
                            }
                        } while (resp1 != 4);
                        break;

                    case 2:
                        do {
                            System.out.println("¿Qué desea realizar?\n\n1.-Registrar diagnostico\n2.-Modificar diagnostico\n3.-Cancelar diagnostico\n4.-Regresar al menu principal");
                            valorValido = true;
                            do {
                                try {

                                    resp2 = Integer.parseInt(lc.nextLine());
                                    valorValido = true;
                                } catch (Exception ex) {
                                    System.out.println("Introduzca un valor valido");
                                    valorValido = false;
                                }
                            } while (valorValido != true);
                            switch (resp2) {
                                case 1:
                                    k++;
                                    System.out.println("Introduzca el nombre");
                                    nombreDiag = lc.nextLine();
                                    System.out.println("Introduzca el nombre de la mascota");
                                    masDiag = lc.nextLine();
                                    System.out.println("Introduzca el diagnóstico");
                                    diagnostico = lc.nextLine();
                                    if (k < 1) {
                                        diag[k].nombre = nombreDiag;
                                        diag[k].nombreMascota = masDiag;
                                        diag[k].diag = diagnostico;
                                        diag[k].cancel=false;
                                    } else {
                                        diag=crecerdiag(diag, k, nombreDiag, masDiag,diagnostico);
                                    }
                                    break;
                                case 2:
                                    for (int j = 0; j < k + 1 ; j++) {
                                        if (diag[j].cancel == false) {
                                            System.out.println(j + ".-\t" + diag[j].nombre + "\t" + diag[j].nombreMascota + "\t" + diag[j].diag);
                                        }
                                    }
                                    System.out.println("Introduzca el número de diagnostico que desearía modificar");
                                    valorValido = true;
                                    do {
                                        try {
                                            modifdiag = Integer.parseInt(lc.nextLine());
                                            valorValido = true;
                                        } catch (Exception ex) {
                                            System.out.println("Introduzca un valor valido");
                                            valorValido = false;
                                        }
                                    } while (valorValido != true);
                                    System.out.println("¿Qué le gustaría modificar?\n\n1.-Nombre\n2.-Nombre de mascota\n3.-Diagnostico");
                                    valorValido = true;
                                    do {
                                        try {
                                            respModificar = Integer.parseInt(lc.nextLine());
                                            valorValido = true;
                                        } catch (Exception ex) {
                                            System.out.println("Introduzca un valor valido");
                                            valorValido = false;
                                        }
                                    } while (valorValido != true);
                                    switch (respModificar) {
                                        case 1:
                                            System.out.println("Introduzca el nombre correcto");
                                            diag[modifdiag].nombre = lc.nextLine();
                                            break;
                                        case 2:
                                            System.out.println("Introduzca el nombre correcto de la mascota");
                                            diag[modifdiag].nombreMascota = lc.nextLine();
                                            break;
                                        case 3:
                                            System.out.println("Introduzca el diagnostico correcto");
                                            diag[modifdiag].diag = lc.nextLine();
                                            break;
                                        default:
                                            System.out.println("Introduzca una opción válida");
                                            break;
                                    }
                                    break;
                                case 3:
                                    for (int j = 0; j < k + 1; j++) {
                                        if (diag[k].cancel == false) {
                                            System.out.println(j + ".-\t" + diag[k].nombre + "\t" + diag[k].nombreMascota + "\t" + diag[k].diag);
                                        }
                                    }
                                    System.out.println("Introduzca el diagnostico que desea cancelar");
                                    valorValido = true;
                                    do {
                                        try {
                                            System.out.println("¿Qué desea realizar?");
                                            cancelardiag = Integer.parseInt(lc.nextLine());
                                            valorValido = true;
                                        } catch (Exception ex) {
                                            System.out.println("Introduzca un valor valido");
                                            valorValido = false;
                                        }
                                    } while (valorValido != true);
                                    diag[cancelardiag].cancel = true;
                                    break;

                            }
                        } while (resp2 != 4);
                        break;
                    case 3:
                        do {
                            System.out.println("Introduzca el reporte que gustaría ver\n1.-Reporte de citas\n2.-Reportes de diagnosticos\n3.-Salir");
                            valorValido = true;
                            do {
                                try {
                                    resp3 = Integer.parseInt(lc.nextLine());
                                    valorValido = true;
                                } catch (Exception ex) {
                                    System.out.println("Introduzca un valor valido");
                                    valorValido = false;
                                }
                            } while (valorValido != true);
                            switch (resp3) {
                                case 1:
                                    System.out.println("\t\t\tREPORTE DE CITAS");
                                    reporteCitas(cita);
                                    break;
                                case 2:
                                    reporteDiag(diag);
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Introduzca un valor válido");
                            }
                        } while (resp3 != 3);
                        break;
                    default:
                        System.out.println("Introduzca un número dentro de las opciones");
                        break;

                }
            } while (resp != 4);

        }

        static Citas[] crecer(Citas[] cita, int length, String nombre, String nombreMas, LocalDate date, LocalTime time) {
            Citas[] temp = new Citas[length + 1];
            temp[length]= new Citas();
            temp[length].ld = date;
            temp[length].lt = time;
            temp[length].nombreCli = nombre;
            temp[length].nombreMascota = nombreMas;
            temp[length].cancelled=false;
            for (int i = 0; i < length; i++) {
                temp[i]= new Citas();
                temp[i].nombreMascota = cita[i].nombreMascota;
                temp[i].nombreCli = cita[i].nombreCli;
                temp[i].ld = cita[i].ld;
                temp[i].lt = cita[i].lt;
                temp[i].cancelled = cita[i].cancelled;
            }
            cita = new Citas[length + 1];
            for (int i = 0; i < length + 1; i++) {
                cita[i] = new Citas();
                cita[i].nombreMascota = temp[i].nombreMascota;
                cita[i].nombreCli = temp[i].nombreCli;
                cita[i].ld = temp[i].ld;
                cita[i].lt = temp[i].lt;
                cita[i].cancelled=temp[i].cancelled;
            }
            return cita;
        }
        static Diagnosticos[] crecerdiag(Diagnosticos[] diag, int length, String nombre, String nombreMas, String diagnos) {
            Diagnosticos[] temp = new Diagnosticos[length + 1];
            temp[length] = new Diagnosticos();
            temp[length].diag = diagnos;
            temp[length].nombre = nombre;
            temp[length].nombreMascota = nombreMas;
            temp[length].cancel = false;
            for (int i = 0; i < length; i++) {
                temp[i]= new Diagnosticos();
                temp[i].nombreMascota = diag[i].nombreMascota;
                temp[i].nombre = diag[i].nombre;
                temp[i].diag = diag[i].diag;
                temp[i].cancel = diag[i].cancel;
            }
            diag = new Diagnosticos[length + 1];
            for (int i = 0; i < length + 1; i++) {
                diag[i]= new Diagnosticos();
                diag[i].nombreMascota = temp[i].nombreMascota;
                diag[i].nombre = temp[i].nombre;
                diag[i].diag = temp[i].diag;
                diag[i].cancel = temp[i].cancel;

            }
            return diag;
        }
static void reporteCitas (Citas[] cita){
    for (int i = 0; i < cita.length; i++) {
    System.out.println(i+".-\t\t"+cita[i].nombreCli+"\t\t"+cita[i].nombreMascota+"\t\t"+cita[i].ld+"\t\t"+cita[i].lt);
    if(cita[i].cancelled==true){
        System.out.println("CITA CANCELADA");}
}
    System.out.println("\n\n");
        }
        static void reporteDiag (Diagnosticos[] diag){
            for (int i = 0; i < diag.length; i++) {
                System.out.println(i+".-\t\t"+diag[i].nombre+"\t\t"+diag[i].nombreMascota+"\t\t"+diag[i].diag);
                if(diag[i].cancel==true){
                    System.out.println("CITA CANCELADA");}
            }
            System.out.println("\n\n");
        }
    }

