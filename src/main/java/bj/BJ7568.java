package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ7568 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Person> people = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        people = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people.add(new Person(weight, height));
        }

        for(int i=0; i<N; i++) {
            Person crPerson = people.get(i);
            int crWeight = crPerson.weight;
            int crHeight = crPerson.height;

            for(int j=0; j<N; j++) {
                if(i == j) {
                    continue;
                }
                Person cpPerson = people.get(j);
                int cpWeight = cpPerson.weight;
                int cpHeight = cpPerson.height;
                if(crWeight > cpWeight && crHeight > cpHeight) {
                    cpPerson.rankUp();
                }
            }
        }

        for(Person person : people) {
            sb.append(person.rank + " ");
        }
        System.out.println(sb.toString());
    }

    public static class Person implements Comparable<Person> {

        int weight;
        int height;
        int rank;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
            this.rank = 1;
        }

        public void rankUp() {
            this.rank++;
        }

        @Override
        public int compareTo(Person p) {
            return this.weight > p.weight && this.height > p.height ? 1 : 0;
        }
    }
}