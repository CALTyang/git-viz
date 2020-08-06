package com.caltyang.viz.gittime;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * <br>
 *
 * @author 作者 <a href="xiaoyang.liu@moji.com">xiaoyang.liu</a>
 * @version 创建时间: 2020/8/6
 */
public class GitTest {

    private static final String REMOTE_URL = "https://github.com/github/testrepo.git";

    @Test
    public void testFetchTags() throws Exception {
        Git git = Git.cloneRepository()
                .setURI(REMOTE_URL)
                .setDirectory(new File("./demo"))
                .call();
        System.out.println("Done.");
    }

    @Test
    public void testPull() throws IOException, GitAPIException {
        Git git = Git.open(new File("./demo"));
        git.pull().call();
    }

    @Test
    public void testListTags() throws Exception {
        Git git = Git.open(new File("./demo"));
        List<Ref> list = git.tagList().call();
//        Collection<Object> commits = new LinkedList<ObjectId>();
//        for (Ref tag : list) {
//            if (tag.getObjectId().equals(commitId)) {
//                commits.add(tag.getName());
//            }
//        }
    }

}
