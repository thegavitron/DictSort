package gavitron;
import java.util.ArrayList;
public class DictSort{
	//Determines the dictionarically most superior word
	String stdOredr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwx";
	char[] stdCharArray;
	String[] words;
	int width;
	public DictSort(){
		stdCharArray = stdOredr.toCharArray();
	}
	int max(int x, int y){
		if(x<y){
			return y;
		}
		else{
			return x;
		}
	}
	int max(int[] a){
		int r = a[0];
		for(int i =0;i<a.length;i++){
			r = max(r,a[i]);
		}
		return r;
	}
	int getHihgestLength(String[] sa){
		int[] a = new int[sa.length];
		for(int i=0;i<sa.length;i++){
			a[i] = sa[i].length();
		}
		return max(a);
	}
	String[] sortFirstLetter(ArrayList<String> sa){
		if(sa.size()==1){
			String[] sc = new String[1];
			sc[0] = sa.get(0);
			return sc;
		}
		ArrayList<String> sorted = new ArrayList<String>();
		for(int i=0;i<stdCharArray.length;i++){
			for(int j=0;j<sa.size();j++){
				if(stdCharArray[i]==sa.get(j).charAt(0)){
					sorted.add(sa.get(j));
				}
			}
		}
		String[] result = new String[sorted.size()];
		for(int i=0;i<sorted.size();i++){
			result[i] = sorted.get(i);
		}
		return result;
	}
	String[] sortFirstLetter(String[] sa){
		if(sa.length==1){
			String[] sc = new String[1];
			sc[0] = sa[0];
			return sc;
		}
		ArrayList<String> sorted = new ArrayList<String>();
		for(int i=0;i<stdCharArray.length;i++){
			for(int j=0;j<sa.length;j++){
				if(stdCharArray[i]==sa[j].charAt(0)){
					sorted.add(sa[j]);
				}
			}
		}
		String[] result = new String[sorted.size()];
		for(int i=0;i<sorted.size();i++){
			result[i] = sorted.get(i);
		}
		return result;
	}
	
	String[] remainVariation(String[] list){
		//removes the first character of each element
		String[] res = new String[list.length];
		for(int i=0;i<list.length;i++){
			res[i] = list[i].substring(1,list[i].length());
		}
		return res;
	}
	String[] predictSuperiors(String[] sortedList){
		//returns the words eligible to be superior
		if(sortedList.length==1){
			String[] sc = new String[1];
			sc[0] = sortedList[0];
			return sc;
		}
		ArrayList<String> result = new ArrayList<String>();
		result.add(sortedList[0]);
		char c = result.get(0).charAt(0);
		for(int i = 1;i<sortedList.length;i++){
			if(sortedList[i].charAt(0)==c){
				result.add(sortedList[i]);
			}
			else{
				break;
			}
		}
		String[] r = new String[result.size()];
		for (int i = 0;i<result.size() ;i++ ) {
			r[i] = result.get(i);
		}
		return r;
	}
	String arrayListOfCharToStr(ArrayList<Character> a){
		StringBuilder sb = new StringBuilder();
		for(char c:a){
			sb.append(c);
		}
		return sb.toString();
	}
	String getSuperiorWord(ArrayList<String> ws){
		String[] w = new String[ws.size()];
		for(int ii=0;ii<ws.size();ii++){
			w[ii] = ws.get(ii);
		}
		return getSuperiorWord(w);
	}
	String getSuperiorWord(String[] w){
		//returns superior word
		//1. creating words
		width = getHihgestLength(w);
		words = new String[w.length];
		for (int i=0;i<w.length ;i++ ) {
			words[i] = w[i];
		}
		//2. calculating superior words
		ArrayList<Character> result = new ArrayList<Character>();
		String[] pastWords = words;
		for(int i=0;i<width;i++){
			String[] presentWords = predictSuperiors(sortFirstLetter(pastWords));
			char c1 = presentWords[0].charAt(0);
			//'.' independent test
			ArrayList<String> terminalChars = new ArrayList<String>();
			for(int j=0;j<presentWords.length;j++){
				if(presentWords[j].length()==1){
					terminalChars.add(presentWords[j]);
				}
			}
			if(terminalChars.size()!=0){
				result.add(predictSuperiors(sortFirstLetter(terminalChars))[0].toCharArray()[0]);
				return arrayListOfCharToStr(result);

			}
			result.add(c1);
			pastWords = remainVariation(presentWords);
		}
		return arrayListOfCharToStr(result);

	}

	public String[] sort(String[] words){
		ArrayList<String> w = new ArrayList<String>();
		for(int ik = 0; ik<words.length;ik++){
			w.add(words[ik]);
		}
		String[] result = new String[words.length];
		for(int h = 0; h<words.length;h++){
			String sw = getSuperiorWord(w);
			result[h] = sw;
			w.remove(sw);
		}
		return result;
	}
	
}

