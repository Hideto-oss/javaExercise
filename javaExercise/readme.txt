#----------------------------------
# This is java execise project.
# And for git test.
# このレポジトリは複数人での git 及び GitHub
# の使い方を練習するためのものです。
# java の課題はおまけ的なもので、昔の日経
# ソフトウェアの付録の問題を参考にしています。
# このレポジトリはメンバー以外の他者からの
# pull request などは受け付けませんので
# ご了承下さい。
# また目的を達成したら直ぐに当レポジトリは
# 削除してしまう可能性がありますので
# 併せてご了承下さい。
#----------------------------------
# 課題 1. 1 から 100 までの数字を画面に出力。
#        ただし 3 の倍数や 3 の付く数字は漢数字で出力
#        それ以外は半角(アラビア)数字で出力のこと
# =========
# 課題 2. 1~25桁の 1 以上の整数値( n1, n2 ) を
#        受け取り、その和(n1 + n2)と差(n1 - n2)を
#        計算して表示せよ(int , long は使えない)
#        BigInteger も使わないこと。
# =========
# 課題 3. 36進数(4桁まで)の数を受け取り 10進数で
#        表示するプログラムを作成せよ。
#        36進数は 0, 1, 2, 3, 4...., 9 の次の
#        A(a)は10 (大文字小文字両方OK)
#        B(b)は11
#        C(c)は12
#        ・
#        ・
#        ・
#        Y(y)は34
#        Z(z)は35  と、定義します。
# =========
# 課題 4. 62進数(4桁まで)の数を受け取り 10進数で
#        表示するプログラムを作成せよ。
#        62進数は 0, 1, 2, 3, 4...., 9 の次の
#        a は 10, b は 11, c は 12, .........
#        y は 34, z は 35,
#        A は 36, B は 37, C は 38, .........
#        Y は 60, Z は 61 とします。
# =========
# 課題 5. 10進数の値を受け取り、その数値を 36進数と
#        62進数で表示するプログラムを作成せよ。
# =========
# 課題 6. 2~10000 の値を受け取り、その数値が素数の
#         場合は「nは素数です」と表示し、素数でない
#         場合は素因数分解をして小さい因子から * で
#         連結して表示するプログラムを作成せよ。
#         (Ex. 20 = 2 * 2 * 5)
# =========
# 課題 7. C言語でかかれたソースコードを読み込み
#         コメントだけを取り出して表示するプログラムを
#         作成せよ。コメントは /* から */ までの間
#         と // から行末まで。各コメントは改行で
#         区切ること。ただし前提条件としてソースコードには
#         1. 全角文字は含まれない。
#         2. " は文字列リテラルの記述のみに現れ
#            文字列中の \" は含まれない。
#         3. 文字定数 '"' も使われない。
#         とします。 (C_sample.txt を利用のこと)

  Block Comment

 One Line Comment
 return 0; /*
 return 2; */

#         実行結果はこうなるように....
# =========
# 課題 8. 課題7.を State デザインパターンを使って
#         実装せよ。
#         class や interface を複数使うであろう
#         ため、Ex8state という package 内で
#         作成して下さい。
# =========
# 課題 9. Command デザインパターンを使って簡易ペイントソフトを
#         実装せよ。GUI は FX を使って欲しいなあ。
#         Ex9command という package 内で作成して下さい。
# =========
# 課題 10. 国旗の画像を使って簡易ゲームソフト(国名当て
#         ゲーム)を実装せよ。GUI は FX を使って下さい。
#         Ex10flag という package 内で作成して下さい。
#         このパッケージ内に Data というフォルダを作って
#         国旗の画像を16個入れておきました。
#         これらの国旗がどの国のものかは自分で調べてね。
# =========
# 課題 11. Iterator デザインパターンを使って
#          本棚(BookShelf)に置かれた本(Book)を
#          順番に表示するプログラムを作成せよ。
#          (Ex11iterator という package 内で)
# =========
# 課題 12. Adapter デザインパターンを使って、与えられた
#          文字列を (Hello) と括弧付きで表示したり
#          *Hello* とアスタリスク付きで表示したりする
#          プログラムを作成せよ。
#          (ただし継承版と委譲版の二つを作成する事)
#          (Ex12adapter1 という package 内で継承版)
#          (Ex12adapter2 という package 内で委譲版)
# =========
# 課題 13. Template Method デザインパターンを使った
#          簡単なサンプルプログラムを作成せよ
#          (ex13TemplateMethod)
# =========
# 課題 14. Factory Method デザインパターンを使った
#          簡単なサンプルプログラムを作成せよ
#          (ex14FactoryMethod)
