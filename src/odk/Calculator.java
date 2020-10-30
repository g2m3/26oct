package generateMeans;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.Arrays;

public class Calculator {

    public Integer orgProd = 0, orgProdMax = 0, twoOneMax = 0, twoOne = 0, twoTwoA = 0, twoTwoB = 0, twoTwoMax = 0,
            twoThreeMax = 0, twoFourMax = 0, twoFiveA = 0, twoFiveB = 0, twoFiveAMax = 0, twoFiveBMax = 0, twoSevenA = 0, twoSevenACant = 0,
            twoSevenB = 0, twoSevenBCant = 0, twoEightACant = 0, twoEightBCant = 0, threeThreeMax = 0, threeSevenMax = 0, threeEightMax = 0,
            threeNineMax = 0, fourTwoMax = 0, fourThreeMax = 0, fourFourMax = 0;
    Double twoEightA = 0.0, twoEightB = 0.0, threeSeven = 0.0, threeNine = 0.0, fourFour = 0.0;
    int[] twoThree = new int[11], twoFour = new int[6], threeThree = new int[4], threeEight = new int[5], fourTwo = new int[3], fourThree = new int[5];
    String cubNCoord = "";

    public void addFormToMean(Path xmlName) {
        try {
            Document doc = Reader.getDocument(xmlName.toString());
            cubNCoord += doc.getElementsByTagName("lat_calc").item(0).getTextContent() + " -" + doc.getElementsByTagName("lon_calc").item(0).getTextContent() + " "
                    + doc.getElementsByTagName("cedula").item(0).getTextContent() + " " + doc.getElementsByTagName("nombrecompleto").item(0).getTextContent() + "\n";

            if (doc.getElementsByTagName("c01_08").item(0) != null) {
                Integer tmp = Integer.parseInt(doc.getElementsByTagName("c01_08").item(0).getTextContent());
                orgProd += tmp == 1 ? 1 : 0;
                orgProdMax++;
            }
            if (doc.getElementsByTagName("c02_01").item(0) != null) {
                Integer tmp = Integer.parseInt(doc.getElementsByTagName("c02_01").item(0).getTextContent());
                twoOne += tmp == 1 ? 1 : 0;
                twoOneMax++;
            }
            if (doc.getElementsByTagName("c02_02").item(0) != null) {
                String tmp = doc.getElementsByTagName("c02_02").item(0).getTextContent();
                twoTwoA += tmp.indexOf('a') > -1 ? 1 : 0;
                twoTwoB += tmp.indexOf('b') > -1 ? 1 : 0;
                twoTwoMax++;
            }
            if (doc.getElementsByTagName("c02_03").item(0) != null) {
                String tmp = doc.getElementsByTagName("c02_03").item(0).getTextContent();
                char c;
                int i;
                for (c = 'a', i = 0; c <= 'k'; ++c, i++) {
                    twoThree[i] += tmp.indexOf(c) > -1 ? 1 : 0;
                }
                twoThreeMax++;
            }
            if (doc.getElementsByTagName("c02_04").item(0) != null) {
                String tmp = doc.getElementsByTagName("c02_04").item(0).getTextContent();
                char c;
                int i;
                for (c = 'a', i = 0; c <= 'f'; ++c, i++) {
                    twoFour[i] += tmp.indexOf(c) > -1 ? 1 : 0;
                }
                twoFourMax++;
            }
            if (doc.getElementsByTagName("c02_05a").item(0) != null) {
                Integer tmp = Integer.parseInt(doc.getElementsByTagName("c02_05a").item(0).getTextContent());
                twoFiveA += tmp == 1 ? 1 : 0;
                twoFiveAMax++;
            }
            if (doc.getElementsByTagName("c02_05b").item(0) != null) {
                Integer tmp = Integer.parseInt(doc.getElementsByTagName("c02_05b").item(0).getTextContent());
                twoFiveB += tmp == 1 ? 1 : 0;
                twoFiveBMax++;
            }
            if (doc.getElementsByTagName("C2G18").item(0) != null && doc.getElementsByTagName("C2G18").item(0).hasChildNodes()) {
                NodeList nodeList = doc.getElementsByTagName("C2G18").item(0).getChildNodes();
                for (int count = 0; count < nodeList.getLength(); count++) {
                    Node tempNode = nodeList.item(count);
                    // make sure it's element node.
                    if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                        twoSevenA += Integer.parseInt(tempNode.getTextContent().replace(".", ""));
                        twoSevenACant++;
                    }
                }
            }
            if (doc.getElementsByTagName("C2G19").item(0) != null && doc.getElementsByTagName("C2G19").item(0).hasChildNodes()) {
                NodeList nodeList = doc.getElementsByTagName("C2G19").item(0).getChildNodes();
                for (int count = 0; count < nodeList.getLength(); count++) {
                    Node tempNode = nodeList.item(count);
                    // make sure it's element node.
                    if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                        twoSevenB += Integer.parseInt(tempNode.getTextContent());
                        twoSevenBCant++;
                    }
                }
            }
            if (doc.getElementsByTagName("C2G20").item(0) != null && doc.getElementsByTagName("C2G20").item(0).hasChildNodes()) {
                NodeList nodeList = doc.getElementsByTagName("C2G20").item(0).getChildNodes();
                for (int count = 0; count < nodeList.getLength(); count += 2) {
                    Node tempNode = nodeList.item(count);
                    // make sure it's element node.
                    if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                        Double quant = Double.parseDouble(tempNode.getTextContent());
                        tempNode = nodeList.item(count + 1);
                        if (tempNode.getTextContent() == "1") {
                            twoEightA += quant * 10000;
                        } else if (tempNode.getTextContent() == "2") {
                            twoEightA += quant * 6400;
                        } else {
                            twoEightA += quant;
                        }
                    }
                    twoEightACant++;
                }
            }
            if (doc.getElementsByTagName("C2G21").item(0) != null && doc.getElementsByTagName("C2G21").item(0).hasChildNodes()) {
                NodeList nodeList = doc.getElementsByTagName("C2G21").item(0).getChildNodes();
                for (int count = 0; count < nodeList.getLength(); count += 2) {
                    Node tempNode = nodeList.item(count);
                    // make sure it's element node.
                    if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                        Double quant = Double.parseDouble(tempNode.getTextContent());
                        tempNode = nodeList.item(count + 1);
                        if (tempNode.getTextContent() == "1") {
                            twoEightB += quant * 10000;
                        } else if (tempNode.getTextContent() == "2") {
                            twoEightB += quant * 6400;
                        } else {
                            twoEightB += quant;
                        }
                    }
                    twoEightBCant++;
                }
            }
            if (doc.getElementsByTagName("c03_03").item(0) != null) {
                threeThree[Integer.parseInt(doc.getElementsByTagName("c03_03").item(0).getTextContent()) - 1]++;
                threeThreeMax++;
            }
            if (doc.getElementsByTagName("c03_07_01").item(0) != null) {
                Integer tmp = Integer.parseInt(doc.getElementsByTagName("c03_07_01").item(0).getTextContent());
                if (tmp == 1) {
                    threeSeven += Double.parseDouble(doc.getElementsByTagName("c03_07").item(0).getTextContent()) * 10000;
                } else if (tmp == 2) {
                    threeSeven += Double.parseDouble(doc.getElementsByTagName("c03_07").item(0).getTextContent()) * 6400;
                } else {
                    threeSeven += Double.parseDouble(doc.getElementsByTagName("c03_07").item(0).getTextContent());
                }
                threeSevenMax++;
            }
            if (doc.getElementsByTagName("c03_08").item(0) != null) {
                String tmp = doc.getElementsByTagName("c03_08").item(0).getTextContent();
                char c;
                int i;
                for (c = 'a', i = 0; c <= 'e'; ++c, i++) {
                    if (tmp.indexOf(c) > -1 && doc.getElementsByTagName("c03_08" + c).item(0) != null) {
                        threeEight[i] += Integer.parseInt(doc.getElementsByTagName("c03_08" + c).item(0).getTextContent());
                    }
                }
                threeEightMax++;
            }
            if (doc.getElementsByTagName("c03_09").item(0) != null) {
                Integer tmp = Integer.parseInt(doc.getElementsByTagName("c03_09_01").item(0).getTextContent());
                if (tmp == 1) {
                    threeNine += Double.parseDouble(doc.getElementsByTagName("c03_09").item(0).getTextContent()) * 10000;
                } else if (tmp == 2) {
                    threeNine += Double.parseDouble(doc.getElementsByTagName("c03_09").item(0).getTextContent()) * 6400;
                } else {
                    threeNine += Double.parseDouble(doc.getElementsByTagName("c03_09").item(0).getTextContent());
                }
                threeNineMax++;
            }
            if (doc.getElementsByTagName("c04_02").item(0) != null) {
                Integer tmp = Integer.parseInt(doc.getElementsByTagName("c04_02").item(0).getTextContent());
                fourTwo[tmp - 1]++;
                fourTwoMax++;
            }
            if (doc.getElementsByTagName("c04_03").item(0) != null) {
                String tmp = doc.getElementsByTagName("c04_03").item(0).getTextContent();
                char c;
                int i;
                for (c = 'a', i = 0; c <= 'e'; ++c, i++) {
                    fourThree[i] += tmp.indexOf(c) > -1 ? 1 : 0;
                }
                fourThreeMax++;
            }
            if (doc.getElementsByTagName("c04_01").item(0) != null) {
                if (doc.getElementsByTagName("c04_01").item(0).getTextContent() == "2") {
                    if (doc.getElementsByTagName("c04_02").item(0) != null && doc.getElementsByTagName("c04_02").item(0).getTextContent() == "2" && doc.getElementsByTagName("c04_04ab").item(0) != null) {
                        Integer tmp = Integer.parseInt(doc.getElementsByTagName("c04_04ab").item(0).getTextContent());
                        if (tmp == 1) {
                            fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04aa").item(0).getTextContent()) * 10000;
                        } else if (tmp == 2) {
                            fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04aa").item(0).getTextContent()) * 6400;
                        } else {
                            fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04aa").item(0).getTextContent());
                        }
                        fourFourMax++;
                        if (doc.getElementsByTagName("c04_04a").item(0) != null) {
                            Node parent = doc.getElementsByTagName("c04_04a").item(0).getParentNode();
                            tmp = Integer.parseInt(parent.getChildNodes().item(1).getTextContent());
                            if (tmp == 1) {
                                fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04a").item(0).getTextContent()) * 10000;
                            } else if (tmp == 2) {
                                fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04a").item(0).getTextContent()) * 6400;
                            } else {
                                fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04a").item(0).getTextContent());
                            }
                            fourFourMax++;
                        }
                    }
                } else if (doc.getElementsByTagName("c04_02").item(0) != null) {
                    if (doc.getElementsByTagName("c04_02").item(0).getTextContent() == "1" && doc.getElementsByTagName("c04_04a").item(0) != null) {
                        Integer tmp = Integer.parseInt(doc.getElementsByTagName("c04_04a").item(0).getTextContent());
                        if (tmp == 1) {
                            fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04").item(0).getTextContent()) * 10000;
                        } else if (tmp == 2) {
                            fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04").item(0).getTextContent()) * 6400;
                        } else {
                            fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04").item(0).getTextContent());
                        }
                        fourFourMax++;
                    } else if (doc.getElementsByTagName("c04_04ab").item(0) != null) {
                        Integer tmp = Integer.parseInt(doc.getElementsByTagName("c04_04ab").item(0).getTextContent());
                        if (tmp == 1) {
                            fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04aa").item(0).getTextContent()) * 10000;
                        } else if (tmp == 2) {
                            fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04aa").item(0).getTextContent()) * 6400;
                        } else {
                            fourFour += Double.parseDouble(doc.getElementsByTagName("c04_04aa").item(0).getTextContent());
                        }
                        fourFourMax++;
                    }
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void printMean() {
        System.out.println(cubNCoord);
        System.out.println("1.8 Productivas: " + orgProd + " de " + orgProdMax);
        System.out.println("2.1 " + twoOne + " de " + twoOneMax);
        System.out.println("2.2 A: " + twoTwoA + ", B: " + twoTwoB + " de " + twoOneMax);
        System.out.println("2.3 " + Arrays.toString(twoThree) + " de " + twoThreeMax);
        System.out.println("2.4 " + Arrays.toString(twoFour) + " de " + twoFourMax);
        System.out.println("2.5 Agrícola: " + twoFiveA + " de " + twoFiveAMax + ", Pecuario: " + twoFiveB + " de " + twoFiveBMax);
        System.out.println("2.7 Agrícola promedio: " + twoSevenA / twoSevenACant + " de un total de " + twoSevenACant + "; Pecuario promedio: " + twoSevenB / twoSevenBCant + " de un total de " + twoSevenBCant);
        System.out.println("2.8 Área promedio para agrícola: " + twoEightA / twoEightACant + " de un total de " + twoEightACant + "; Pecuario área promedio: " + twoEightB / twoEightBCant + " de un total de " + twoEightBCant);
        System.out.println("3.3 Tipo de pendiente. Plano: " + 100 * threeThree[0] / threeThreeMax + "%, Ondulado: " + 100 * threeThree[1] / threeThreeMax + "%, Quebrado: " + 100 * threeThree[2] / threeThreeMax + "%, Escarpado: " + 100 * threeThree[3] / threeThreeMax + "% de un total de " + threeThreeMax);
        System.out.println("3.7 Promedio área de los predios: " + (int) (threeSeven / threeSevenMax) + "m2 de un total de " + threeSevenMax);
        System.out.println("3.8 Coberturas de los predios. Cultivos: " + threeEight[0] / threeEightMax + ", Pastos/rastrojos: " + threeEight[1] / threeEightMax + ", Bosques: " + threeEight[2] / threeEightMax + ", Zonas eriales: " + threeEight[3] / threeEightMax + ", Otros: " + threeEight[4] / threeEightMax + " de un total de " + threeEightMax);
        System.out.println("3.9 Promedio del área a utilizar : " + (int) (threeNine / threeNineMax) + " de un total de " + threeNineMax);
        System.out.println("4.2 Tipo de actividad productiva desarrollada. Agrícola: " + 100 * fourTwo[0] / fourTwoMax + "%, Pecuaria: " + 100 * fourTwo[1] / fourTwoMax + "%, Otras: " + 100 * fourTwo[2] / fourTwoMax + "% de un total de " + fourTwoMax);
        System.out.println("4.3 Por etapas de la actividad productiva: " + Arrays.toString(fourThree) + " de " + fourThreeMax);
        System.out.println("4.4 Promedio área cultivada: " + (int) (fourFour / fourFourMax) + "m2 de un total de " + fourFourMax);

        PrintWriter writer;
        try {
            writer = new PrintWriter("results.txt", "UTF-8");
            writer.println(cubNCoord);
            writer.println("1.8 Productivas: " + orgProd + " de " + orgProdMax);
            writer.println("2.1 " + twoOne + " de " + twoOneMax);
            writer.println("2.2 A: " + twoTwoA + ", B: " + twoTwoB + " de " + twoOneMax);
            writer.println("2.3 " + Arrays.toString(twoThree) + " de " + twoThreeMax);
            writer.println("2.4 " + Arrays.toString(twoFour) + " de " + twoFourMax);
            writer.println("2.5 Agrícola: " + twoFiveA + " de " + twoFiveAMax + ", Pecuario: " + twoFiveB + " de " + twoFiveBMax);
            writer.println("2.7 Agrícola promedio: " + twoSevenA / twoSevenACant + " de un total de " + twoSevenACant + "; Pecuario promedio: " + twoSevenB / twoSevenBCant + " de un total de " + twoSevenBCant);
            writer.println("2.8 Área promedio para agrícola: " + twoEightA / twoEightACant + " de un total de " + twoEightACant + "; Pecuario área promedio: " + twoEightB / twoEightBCant + " de un total de " + twoEightBCant);
            writer.println("3.3 Tipo de pendiente. Plano: " + 100 * threeThree[0] / threeThreeMax + "%, Ondulado: " + 100 * threeThree[1] / threeThreeMax + "%, Quebrado: " + 100 * threeThree[2] / threeThreeMax + "%, Escarpado: " + 100 * threeThree[3] / threeThreeMax + "% de un total de " + threeThreeMax);
            writer.println("3.7 Promedio área de los predios: " + (int) (threeSeven / threeSevenMax) + "m2 de un total de " + threeSevenMax);
            writer.println("3.8 Coberturas de los predios. Cultivos: " + threeEight[0] / threeEightMax + ", Pastos/rastrojos: " + threeEight[1] / threeEightMax + ", Bosques: " + threeEight[2] / threeEightMax + ", Zonas eriales: " + threeEight[3] / threeEightMax + ", Otros: " + threeEight[4] / threeEightMax + " de un total de " + threeEightMax);
            writer.println("3.9 Promedio del área a utilizar : " + (int) (threeNine / threeNineMax) + " de un total de " + threeNineMax);
            writer.println("4.2 Tipo de actividad productiva desarrollada. Agrícola: " + 100 * fourTwo[0] / fourTwoMax + "%, Pecuaria: " + 100 * fourTwo[1] / fourTwoMax + "%, Otras: " + 100 * fourTwo[2] / fourTwoMax + "% de un total de " + fourTwoMax);
            writer.println("4.3 Por etapas de la actividad productiva: " + Arrays.toString(fourThree) + " de " + fourThreeMax);
            writer.println("4.4 Promedio área cultivada: " + (int) (fourFour / fourFourMax) + "m2 de un total de " + fourFourMax);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
