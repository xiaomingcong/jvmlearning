package jvmLearning.chapter10;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;
//可以用"*"表示支持所有Annotations
@SupportedAnnotationTypes("*")
//只支持JDK1.6的Java代码
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameCheckProcessor extends AbstractProcessor {

    private NameChecker nameChecker;

    /**
     * 初始化名称检查器
     * @param processingEnv
     */
    @Override
    public void init(ProcessingEnvironment processingEnv){
        super.init(processingEnv);
        nameChecker = new NameChecker(processingEnv);
    }

    /**
     * 对输入语法树的各个节点进行名称检查
     * @param annotations
     * @param roundEnv
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if(!roundEnv.processingOver()){
            for(Element element:roundEnv.getRootElements())
                nameChecker.checkNames(element);
        }
        return false;
    }

    @Override
    protected synchronized boolean isInitialized() {
        return super.isInitialized();
    }
}
