package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("TheTest2");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size()+1));
        group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
        assertThat(after, equalTo(before.withAdded(group)));
    }
}