public class Histogram{

        private int range;
        private int upperbound;
        private int lowerbound;
        private int[] occurances;

        public Histogram(int lowerbound, int upperbound){
              this.lowerbound = lowerbound;
              this.upperbound = upperbound;
              range = upperbound - lowerbound;
              occurances = new int[range+1];

        }

        public boolean add(int i){
            if (i <= upperbound && i >= lowerbound){
              occurances[i-lowerbound] = occurances[i-lowerbound] + 1;
              return true;
            }
            return false;
        }

        public String toString(){
              String str = "";
              int numbInRng;
              for (int i = 0; i <range +1; i++){
                  numbInRng = i + lowerbound;
                  str = str + "" + numbInRng +":";
                  for (int j = 0; j < occurances[i]; j++){
                      str = str + "*";
                  }
                  str = str + "\n";
              }
              return str;
        }
}
