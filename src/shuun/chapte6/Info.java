package shuun.chapte6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// CLASS : コンパイル時にクラスファイルに記録される。実行時にVMに読み込まれない。
// RUNTIME : 実行時にVMに読み込まれる
// SOURCE : コンパイル時に破棄
@Target(ElementType.METHOD)
// ANNOTATION_TYPE : アノテーションに適用可
// CONSTRUCTOR : コンストラクタに適用可
// FIELD : フィールドに適用可
//LOCAL_VARIABLE : ローカルに適用可
//METHOD : メソッドに適用可
//PACKAGE : パッケージに適用可
//PARAMETER : 引数に適用可
public @interface Info {
	String value();
}
