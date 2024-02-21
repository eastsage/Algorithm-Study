import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, K;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int result = 0;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		visited = new boolean[R + 1][C + 1];

		for (int i = 1; i <= R; i++) {
			String input = br.readLine();
			for (int j = 1; j <= C; j++) {
				char c = input.charAt(j - 1);
				map[i][j] = c;

				if (c == 'T')
					visited[i][j] = true;
			}
		}

		visited[R][1] = true;
		dfs(R, 1, 1);

		System.out.println(result);
		br.close();
	}

	static void dfs(int r, int c, int depth) {
		if (r == 1 && c == C) {
			if (depth == K)
				result++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (1 <= nr && nr <= R && 1 <= nc && nc <= C) {
				if (visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				map[nr][nc] = '-';
				dfs(nr, nc, depth + 1);
				visited[nr][nc] = false;
				map[nr][nc] = '.';
			}
		}
	}

}